package com.ivatolm.sem6.third;

import java.util.Optional;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class President extends Human implements DrivingAbility {

    private static President instance = null;
    private Optional<Transport> transport;

    private Optional<List<River>> path;
    private Optional<Integer> pathPointer;

    private Integer lastPathPointer;

    private President(Vector3 position) {
        super("Biblbroks", position);

        this.path = Optional.empty();
        this.pathPointer = Optional.empty();

        this.lastPathPointer = -1;
    }

    static public President getInstance() {
        return getInstance(null);
    }

    static public President getInstance(Vector3 position) {
        if (instance != null) return instance;
        instance = new President(position);
        return instance;
    }

    public void setPath(List<River> path) {
        if (path.isEmpty()) {
            this.path = Optional.empty();
            this.pathPointer = Optional.empty();
            return;
        }
        this.path = Optional.of(path);
        this.pathPointer = Optional.of(0);
        System.out.println("New path... " + path.size() + " rivers ahead...");
    }

    @Override
    public void mount(Transport transport) {
        this.transport = Optional.of(transport);
        this.transport.get().setPosition(this.position);
        System.out.println(this.getName() + " hops onto " + transport.getName());
        this.transport.get().start();
    }

    @Override
    public void unmount() {
        System.out.println(this.getName() + " gets off " + this.transport.get().getName());
        this.transport.get().stop();
        this.transport = Optional.empty();
    }

    @Override
    public Vector3 ride() {
        final double EPSILON = 5.0;

        if (this.pathPointer.isEmpty()) {
            return new Vector3(0, 0, 0);
        }

        final List<River> path = this.path.get();
        final Integer pathPointer = this.pathPointer.get();


        final River river = path.get(pathPointer);
        final Vector3 target = new Vector3(
            river.getPosition().getX() + river.getWidth(),
            river.getPosition().getY(),
            river.getPosition().getZ());

        if (lastPathPointer < pathPointer) {
            System.out.println("Now crossing " + river.getName() + " it's about " + Math.round(river.getWidth()) + " meters wide");
            lastPathPointer = pathPointer;
        }

        this.transport.get().setDestination(target);
        final Vector3 difference = this.transport.get().ride();
        this.position = this.transport.get().getPosition();
        if (!(difference.getX() <= EPSILON && difference.getY() <= EPSILON && difference.getZ() <= EPSILON)) {
            return difference;
        }

        if (pathPointer < path.size() - 1) {
            this.pathPointer = Optional.of(pathPointer + 1);
        }

        return difference;
    }

}
