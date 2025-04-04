package com.ivatolm.sem6.third;

import java.util.Optional;
import java.util.List;

class President extends Human implements DrivingAbility {

    private static President instance = null;
    private Optional<Transport> transport;
    private List<River> path;
    private Integer pathPointer;

    private President(Integer id, Vector3 position, List<River> path) {
        super(id, "Biblbroks", position);

        this.path = path;
        this.pathPointer = 0;
    }

    public President getInstance() {
        return getInstance(null, null, null);
    }

    public President getInstance(Integer id, Vector3 position, List<River> path) {
        if (instance != null) return instance;
        instance = new President(id, position, path);
        return instance;
    }

    @Override
    public void mount(Transport transport) {
        this.transport = Optional.of(transport);
    }

    @Override
    public void unmount() {
        this.transport = Optional.empty();
    }

    @Override
    public void ride() {
        final double EPSILON = 0.05;

        if (this.pathPointer >= this.path.size()) {
            return;
        }

        final River river = this.path.get(this.pathPointer);
        final Vector3 target = new Vector3(
                river.getPosition().getX() + river.getWidth(),
                river.getPosition().getY(),
                river.getPosition().getZ());

        this.transport.get().setDestination(target);
        final Vector3 difference = this.transport.get().ride();
        if (!(difference.getX() <= EPSILON && difference.getY() <= EPSILON && difference.getZ() <= EPSILON)) {
            return;
        }

        if (this.pathPointer < this.path.size() - 1) {
            pathPointer++;
        }
    }

}