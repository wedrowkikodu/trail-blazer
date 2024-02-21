package pl.wedrowkikodu.trailblazer.model;

import lombok.Data;

import java.util.List;

@Data
public class Trail {
    private String id;
    private String name;
    private double length;
    private String difficulty;
    private List<Landmark> landmarks;

    // Add landmark to the trail
    public void addLandmark(Landmark landmark) {
        landmarks.add(landmark);
    }

    // Remove landmark from the trail
    public void removeLandmark(Landmark landmark) {
        landmarks.remove(landmark);
    }
}
