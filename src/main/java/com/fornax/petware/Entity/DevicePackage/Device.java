package com.fornax.petware.Entity.DevicePackage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fornax.petware.Entity.AnimalPackage.Pet;
import com.fornax.petware.Entity.CoordinatesPackage.Coordinate;
import com.fornax.petware.Entity.GeofencesPackages.Geofences;
import com.fornax.petware.Entity.UserPackage.User;
import jakarta.persistence.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.net.URL;


import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int serialNumber;

    private String ubication;


    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "device-coordinates")
    List<Coordinate> coordinate = new ArrayList<>();

    public Device() {
    }

    public Device(long id, int serialNumber, String ubication ) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ubication = ubication;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }


    public void updateCoordinates(float newLat, float newLng) {
        for (Coordinate coordinate : coordinate) {
            coordinate.setLat(newLat);
            coordinate.setLng(newLng);
        }
    }

    public String[] updateCoords() {
        try {
            String filePath = "src/main/resources/IOsecrets.json";
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
            JSONObject jsonObject = new JSONObject(content.toString());
            String aioKey = jsonObject.getString("secretKey");
            String feedURL = jsonObject.getString("FeedUrl");
            URL url = new URL(feedURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-AIO-Key", aioKey);
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return obtenerLastValue(response.toString());
            } else {
                return Collections.singletonList("Error: Unable to connect to AdaFruit IO").toArray(new String[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        return Collections.singletonList("Error: Unable to connect to AdaFruit IO").toArray(new String[0]);
    }

    public static String[] obtenerLastValue(String ResponseURL) {
        String pattern = "\"last_value\":\"(.*?)\"";
        Pattern regexPattern = Pattern.compile(pattern);

        Matcher matcher = regexPattern.matcher(ResponseURL);

        if (matcher.find()) {
            String lastValue = matcher.group(1);
            // Split the lastValue into two parts using the "|" character
            String[] values = lastValue.split("\\|");
            return values;
        } else {
            // Return an array with a default value if "last_value" is not found
            return new String[]{"No se encontró \"last_value\""};
        }
    }

}
