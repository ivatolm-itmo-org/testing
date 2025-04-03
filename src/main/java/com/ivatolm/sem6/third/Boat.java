package com.ivatolm.sem6.third;

class Boat extends Transport {

    private double motorPower;
    private boolean motorStarted;

    public Boat(Integer id, Vector3 position, Vector3 velocity, double motorPower) {
        super(id, TransportType.TRANSPORT_TYPE_BOAT, position, velocity);

        this.motorPower = motorPower;
        this.motorStarted = false;
    }

    @Override
    public void start() {
        this.motorStarted = true;
    }

    @Override
    public void stop() {
        this.motorStarted = false;
    }

    @Override
    public Vector3 ride() {
        // TODO: Move towards target
        // Accelerate up to a point, for example 10,10,10
        return new Vector3(0, 0, 0);
    }

}