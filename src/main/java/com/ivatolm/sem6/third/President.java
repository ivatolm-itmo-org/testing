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
    private List<River> path;
    private Integer pathPointer;

    private President(Integer id, Vector3 position, List<River> path) {
        super(id, "Biblbroks", position);

        this.path = path;
        this.pathPointer = 0;
    }

    static public President getInstance() {
        return getInstance(null, null, null);
    }

    static public President getInstance(Integer id, Vector3 position, List<River> path) {
        if (instance != null) return instance;
        instance = new President(id, position, path);
        return instance;
    }

    @Override
    public void mount(Transport transport) {
        this.transport = Optional.of(transport);
        this.transport.get().setPosition(this.position);
        this.transport.get().start();
    }

    @Override
    public void unmount() {
        this.transport = Optional.empty();
        this.transport.get().stop();
    }

    @Override
    public Vector3 ride() {
        final double EPSILON = 5.0;

        if (this.pathPointer >= this.path.size()) {
            return new Vector3(0, 0, 0);
        }

        final River river = this.path.get(this.pathPointer);
        final Vector3 target = new Vector3(
                river.getPosition().getX() + river.getWidth(),
                river.getPosition().getY(),
                river.getPosition().getZ());

        this.transport.get().setDestination(target);
        final Vector3 difference = this.transport.get().ride();
        this.position = this.transport.get().getPosition();
        if (!(difference.getX() <= EPSILON && difference.getY() <= EPSILON && difference.getZ() <= EPSILON)) {
            return difference;
        }

        if (this.pathPointer < this.path.size() - 1) {
            this.pathPointer++;
        }

        return difference;
    }

}