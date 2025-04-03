package com.ivatolm.sem6.third;

import java.util.Optional;

class President extends Human implements DrivingAbility {

    private static President instance = null;
    private Optional<Transport> transport;

    private President(Integer id, Vector3 position) {
        super(id, "Biblbroks", position);
    }

    // NOTE: Java loves overloading stuff, much better that default values, i agree
    public President getInstance() {
        return getInstance(null, null);
    }

    public President getInstance(Integer id, Vector3 position) {
        if (instance != null) return instance;
        instance = new President(id, position);
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
        // TODO: ...
    }

}