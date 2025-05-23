package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boat extends Transport {

    private double motorPower;
    private boolean motorStarted;

    private Integer notificationCounter;

    public Boat(String name, Vector3 position, double motorPower) {
        super(name, TransportType.TRANSPORT_TYPE_BOAT, position);

        this.motorPower = motorPower;
        this.motorStarted = false;

        this.notificationCounter = 0;
    }

    @Override
    public void start() {
        this.motorStarted = true;
        System.out.println("Vrrr-chk... VROOOM!");
    }

    @Override
    public void stop() {
        this.motorStarted = false;
        System.out.println("VROOOM... putt-putt... clunk");
    }

    @Override
    public Vector3 ride() {
        final double DELTA_TIME = 1.0;
        final double MAX_AXIS_VELOCITY = 1.0;

        if (!this.motorStarted) {
            return new Vector3(0, 0, 0);
        }

        final Vector3 direction = new Vector3(
            this.position.getX() - this.destination.getX(),
            this.position.getY() - this.destination.getY(),
            this.position.getZ() - this.destination.getZ());
        direction.normalize();
        direction.invert();

        this.acceleration.setX(this.motorPower * direction.getX());
        this.acceleration.setY(this.motorPower * direction.getY());
        this.acceleration.setZ(this.motorPower * direction.getZ());

        this.velocity.setX(this.velocity.getX() + this.acceleration.getX() * DELTA_TIME);
        this.velocity.setY(this.velocity.getY() + this.acceleration.getY() * DELTA_TIME);
        this.velocity.setZ(this.velocity.getZ() + this.acceleration.getZ() * DELTA_TIME);

        this.velocity.setX(Math.min(this.velocity.getX(), MAX_AXIS_VELOCITY));
        this.velocity.setY(Math.min(this.velocity.getY(), MAX_AXIS_VELOCITY));
        this.velocity.setZ(Math.min(this.velocity.getZ(), MAX_AXIS_VELOCITY));

        this.position.setX(this.position.getX() + this.velocity.getX() * DELTA_TIME);
        this.position.setY(this.position.getY() + this.velocity.getY() * DELTA_TIME);
        this.position.setZ(this.position.getZ() + this.velocity.getZ() * DELTA_TIME);

        final Vector3 difference = new Vector3(
            Math.abs(this.position.getX() - this.destination.getX()),
            Math.abs(this.position.getY() - this.destination.getY()),
            Math.abs(this.position.getZ() - this.destination.getZ()));

        if (notificationCounter % 10 == 0) {
            System.out.println("Target distance " + Math.round(difference.length()) + " meters.");
            this.notificationCounter = 1;
        }
        this.notificationCounter++;

        return difference;
    }

}
