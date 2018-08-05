package com.neeson.Thread.course9;


import java.util.HashSet;
import java.util.Set;


/**
 * 在协作对象之间发生的死锁
 * Created by daile on 2017/9/11.
 */
public class Taxi {

    private com.neeson.thread.course3.Point location,destination;
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized com.neeson.thread.course3.Point getLocation(){
        return location;
    }

    public synchronized void setLocation(com.neeson.thread.course3.Point location){
        this.location = location;
        if (location.equals(destination)) {
            dispatcher.notify();
        }
    }

    class Dispatcher{

        private final Set<Taxi> taxis;
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            this.taxis = new HashSet<>();
            this.availableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(Taxi taxi){
            availableTaxis.add(taxi);
        }

        public synchronized Image getImage(){
            Image image = new Image();
            for (Taxi t:taxis)
                image.drawMarker(t.getLocation());
            return image;
        }

    }

}
