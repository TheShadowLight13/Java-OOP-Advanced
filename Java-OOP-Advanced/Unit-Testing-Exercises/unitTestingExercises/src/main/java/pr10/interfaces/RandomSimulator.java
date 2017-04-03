package pr10.interfaces;

import java.util.Random;

public interface RandomSimulator {

    double nextDouble();

    class RandomPressureSampleSimulator implements RandomSimulator {

        private Random random;

        public RandomPressureSampleSimulator() {
            this.random = new Random();
        }

        public double nextDouble() {
            return random.nextDouble();
        }
    }
}
