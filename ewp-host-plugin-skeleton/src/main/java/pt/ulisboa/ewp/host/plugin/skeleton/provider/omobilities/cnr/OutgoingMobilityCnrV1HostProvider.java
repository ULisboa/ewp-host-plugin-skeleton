package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities.cnr;

import java.util.Collection;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Outgoing Mobilities from the host (V1).
 */
public abstract class OutgoingMobilityCnrV1HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Called when a change notification of an outgoing mobility emitted by one of partner institutions.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-cnr/tree/stable-v1">EWP
     *      Specification</a>
     *
     * @param sendingHeiId Identifier of the HEI which is the sending partner of the outgoing mobilities that have been changed.
     * @param outgoingMobilityIds Outgoing Mobilities IDs that were changed.
     */
    public abstract void onChangeNotification(String sendingHeiId, Collection<String> outgoingMobilityIds);

    /**
     * Indicates the maximum number of Outgoing Mobility IDs that can be handled on any request.
     * 
     * @return Maximum number of Outgoing Mobility IDs
     */
    public int getMaxOutgoingMobilityIdsPerRequest() {
        return DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST;
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}
