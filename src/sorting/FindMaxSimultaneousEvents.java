package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Event {
    public int start, finish;

    public Event(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Endpoint implements Comparable<Endpoint> {
    public int time;
    public boolean isStart;

    Endpoint(int t, boolean is) {
        time = t;
        isStart = is;
    }

    public int compareTo(Endpoint e) {
        if (time != e.time) {
            return Integer.compare(time, e.time);
        }

        int value = isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
        // If times are equal, an endpoint that starts an interval comes first.
        return value;
    }
}

public class FindMaxSimultaneousEvents {

    public int findMaxSimultaneousEvents(List<Event> A) {
// Builds an array of all endpoints.
        List<Endpoint> E = new ArrayList<>();
        for (Event event : A) {
            E.add(new Endpoint(event.start, true));
            E.add(new Endpoint(event.finish, false));
        }

        // Sorts the endpoint array according to the time, breaking ties
// by putting start times before end times.
        Collections.sort(E);
// Track the number of simultaneous events, and record the maximum
// number of simultaneous events.
        int maxNumSimultaneousEvents = 0, numSimultaneousEvents = 0;
        for (Endpoint endpoint : E) {
            if (endpoint.isStart) {
                ++numSimultaneousEvents;
                maxNumSimultaneousEvents
                        = Math.max(numSimultaneousEvents, maxNumSimultaneousEvents);
            } else {
                --numSimultaneousEvents;
            }
        }
        return maxNumSimultaneousEvents;
    }

    public static void main(String[] args) {
        Event event1 = new Event(1, 5);
        Event event2 = new Event(6,   10);
        Event event3 = new Event(11, 13);
        Event event4 = new Event(14, 15);
        Event event5 = new Event(2, 7);
        Event event6 = new Event(8, 9);
        Event event7 = new Event(12, 15);
        Event event8 = new Event(4, 5);
        Event event9 = new Event(9, 17);

        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);
        list.add(event3);
        list.add(event4);
        list.add(event5);
        list.add(event6);
        list.add(event7);
        list.add(event8);
        list.add(event9);

        FindMaxSimultaneousEvents events = new FindMaxSimultaneousEvents();
        System.out.println(events.findMaxSimultaneousEvents(list));

    }
}

