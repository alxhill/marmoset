package com.graphhopper.marmoset.vehicle;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.EdgeIteratorState;

import java.util.List;

/**
 * Created by alexander on 20/04/2016.
 */
public class SelfDrivingVehicleIterator extends DijkstraVehicleIterator {

    protected SelfDrivingVehicleIterator() {}

    public SelfDrivingVehicleIterator(List<EdgeIteratorState> edges, FlagEncoder encoder)
    {
        super(edges, encoder);
    }

    public void resetEdges(List<EdgeIteratorState> edgeList)
    {
        index = 0;
        this.edges = edgeList;
        edges.remove(edges.size() - 1);
    }

    public int getRemainingEdges()
    {
        return edges.size() - index;
    }

    @Override
    public SelfDrivingVehicleIterator duplicate()
    {
        SelfDrivingVehicleIterator sdvi = new SelfDrivingVehicleIterator();
        sdvi.encoder = encoder;
        sdvi.edge = edge;
        sdvi.edges = edges;
        sdvi.index = index;
        return sdvi;
    }
}
