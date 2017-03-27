package pr09;

import pr09.enums.Lights;

import java.util.Arrays;

public class TrafficLight {

    private Lights currLight;
    private Lights[] nextLights;

    public TrafficLight(Lights currLight, Lights[] nextLights) {
        this.setCurrLight(currLight);
        this.nextLights = nextLights;
    }

    public Lights getCurrLight() {
        return this.currLight;
    }

    private void setCurrLight(Lights currLight) {
        this.currLight = currLight;
    }

    public Lights[] getNextLights() {
        return this.nextLights;
    }

    private void setLightOnIndex(Lights light, int index) {
        this.nextLights[index] = light;
    }

    public int getNextLightsCount() {
        return this.getNextLights().length;
    }

    public void updateLights() {
        Lights[] previousLights = Arrays.copyOf(this.getNextLights(), this.getNextLightsCount());

        this.setLightOnIndex(this.getCurrLight(), 0);
        int currLightIndex = this.getCurrLight().ordinal();

        if (this.getNextLightsCount() == 1) {
            currLightIndex = getNextLightIndex(currLightIndex + 1);
            this.setLightOnIndex(Lights.values()[currLightIndex], 0);
        }

        for (int i = 1; i < this.getNextLightsCount(); i++) {
            Lights previousLight = previousLights[i - 1];
            Lights nextLight = previousLights[i];

            if (previousLight.ordinal() < nextLight.ordinal()) {
                currLightIndex++;
            }else {
                currLightIndex--;
            }

            currLightIndex = getNextLightIndex(currLightIndex);
            this.setLightOnIndex(Lights.values()[currLightIndex], i);
        }

        int lastLightIndex = this.getNextLightsCount() - 1;
        this.setCurrLight(Lights.values()[lastLightIndex]);
    }

    public int getNextLightIndex(int currLightIndex) {
        int nextLightIndex = currLightIndex;

        if (nextLightIndex >= Lights.values().length) {
            nextLightIndex = 0;
        }else if (nextLightIndex < 0) {
            nextLightIndex = Lights.values().length - 1;
        }

        return nextLightIndex;
    }
}
