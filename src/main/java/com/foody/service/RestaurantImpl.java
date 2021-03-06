package com.foody.service;

import com.foody.entity.FoodType;
import com.foody.entity.Restaurant;
import com.foody.entity.RestaurantType;
import com.foody.repository.FoodTypeRepository;
import com.foody.repository.RestaurantRepository;
import com.foody.repository.RestaurantTypeRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;

@Service
public class RestaurantImpl implements RestaurantService{
    InputStream inputStream;
    String result = "";

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private RestaurantTypeRepository restaurantTypeRepository;

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

    // Only admin has privileges to add new restaurant
    @Override
    public void addRestaurant(Map<String, Object> payload) throws IOException, JSONException {
        Restaurant restaurant = new Restaurant();
        JSONObject json = new JSONObject(payload);

        JSONObject restaurant_object = new JSONObject(json.getJSONObject("restaurant").toString());
        JSONArray food_types_object = restaurant_object.getJSONArray("food_types");

        List<FoodType> foodTypes = new ArrayList<>();
        for (int i = 0; i < food_types_object.length(); i++) {
            FoodType foodType=foodTypeRepository.getFoodType(food_types_object.getInt(i));
            foodTypes.add(foodType);
        }

        JSONArray restaurant_types_object = restaurant_object.getJSONArray("restaurant_types_id");
        List<RestaurantType> restaurantTypes = new ArrayList<>();
        for (int i = 0; i < restaurant_types_object.length(); i++) {
            restaurantTypes.add(restaurantTypeRepository.getType(restaurant_types_object.getInt(i))) ;
        }

        restaurant.setName(restaurant_object.getString("name"));
        restaurant.setEmail(restaurant_object.getString("email"));
        restaurant.setAddress(restaurant_object.getString("address"));
        restaurant.setPhoneNumber(restaurant_object.getString("phoneNumber"));
        restaurant.setRestaurant_types(restaurantTypes);
        restaurant.setFood_types(foodTypes);

        double[] location= getLocation_object(restaurant.getAddress());
        restaurant.setLat(location[0]);
        restaurant.setLng(location[1]);

        restaurantRepository.save(restaurant);

//        User user=userService.getUser(user_id);

//        if(user!=null) {
//           if (user.getRole().getName().equals("admin")) {
//               restaurantRepository.save(restaurant);
//           } else{
//               new ResourceNotFoundException("User is not admin");
//           }
//       }
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
        String encoded_address=String.join("+", address.split(" "));
        String string_url="https://maps.googleapis.com/maps/api/geocode/json?address="+encoded_address+"&key="+google_key_api;

        URL url = new URL(string_url);
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
    public List<Restaurant.SearchRestaurantInterface> getRestaurantListBySearch(Map<String, Object> payload) throws JSONException {
        JSONObject preferences = new JSONObject(payload);

        Restaurant restaurant = new Restaurant();
        double lat=preferences.getDouble("lat");
        double lng=preferences.getDouble("lng");

        JSONArray food_types_object = preferences.getJSONArray("food_types");
        List<Integer> foodTypes = new ArrayList<>();
        for (int i = 0; i < food_types_object.length(); i++) {
            foodTypes.add(food_types_object.getInt(i));
        }

        JSONArray res_types_object = preferences.getJSONArray("cuisine");
        List<Integer> res_types = new ArrayList<>();
        for (int i = 0; i < res_types_object.length(); i++) {
            res_types.add(res_types_object.getInt(i));
        }

        int distance=preferences.getInt("distance");
        List<Restaurant.SearchRestaurantInterface> restaurants= restaurantRepository.getRestaurantResults(lat, lng, foodTypes, res_types, distance);

        return restaurants;
    }

}
