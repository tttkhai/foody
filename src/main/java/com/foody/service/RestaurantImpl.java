package com.foody.service;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import com.foody.entity.User;
import com.foody.repository.RestaurantRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class RestaurantImpl implements RestaurantService{
    InputStream inputStream;
    String result = "";

    @Autowired
    private RestaurantRepository restaurantRepository;
    private UserService userService;

    @Override
    public List<Restaurant> allRestaurants() {
        List<Restaurant> restaurantList= new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurantList::add);
        return restaurantList;
    }

    @Override
    public Restaurant restaurantById(int id) {
        return restaurantRepository.findById(id).map(res->{
            return res;
        }).orElseThrow(()->new ResourceNotFoundException("Restaurant Id  " + id + " not found"));
    }

    @Override
    public List<Restaurant> restaurantByLocation(int zip_code) {
        return restaurantRepository.restaurantByLocation(zip_code);
    }

    // only admin has privileges to add new restaurant
    @Override
    public Restaurant addRestaurant(int user_id, Restaurant restaurant) throws IOException, JSONException {
        User user=userService.getUser(user_id);
        double[] location= getLocation_object(restaurant.getAddress());
        restaurant.setLat(location[0]);
        restaurant.setLat(location[1]);
        if(user!=null) {
           if (user.getRoles().stream().filter(role -> {return role.getName().equals("admin");})==null) {
               return restaurantRepository.save(restaurant);
           }
       }
        return null;
    }

    @Override
    public double[] getLocation_object(String address) throws IOException, JSONException {
        Properties prop = new Properties();
        String propFile = "privatekeys.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFile);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
        }

        String google_key_api=prop.getProperty("google_key_api");

        System.out.println("this is API key: "+google_key_api);
        String uri="https://maps.googleapis.com/maps/api/geocode/json?";
        URL url = new URL(uri+"address="+address+"&key="+google_key_api);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuffer response = new StringBuffer();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject myResponse = new JSONObject(response.toString());
        JSONObject results_object = new JSONObject(myResponse.getJSONArray("results").get(0).toString());
        JSONObject geometry_object = new JSONObject(results_object.getJSONObject("geometry").toString());
        JSONObject location_object = new JSONObject(geometry_object.getJSONObject("location").toString());
        double lat=location_object.getDouble("lat");
        double lng=location_object.getDouble(("lng"));
        double[] location;
        return new double[]{lat, lng};
    }

    @Override
    public List<Restaurant> getRestaurantListBySearch(double lat, double lng, List<FoodType> food_types, List<RestaurantType> res_types, double distance) {
        return null;
    }

}
