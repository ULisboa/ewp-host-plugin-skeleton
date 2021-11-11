package pt.ulisboa.ewp.host.plugin.skeleton.provider.imobilities.cnr;

import java.util.Collection;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to notify a host about a change notification on some incoming mobility kept by some partner
 * institution (V1).
 */
public abstract class IncomingMobilityCnrV1HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Called when a change notification of an incoming mobility emitted by some partner institutions.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-imobility-cnr/tree/stable-v1">EWP
     *      Specification</a>
     *
     * @param receivingHeiId Identifier of the HEI which is the receiving institution of the incoming mobilities that have been
     *            changed.
     * @param outgoingMobilityIds Outgoing Mobilities IDs that were changed.
     */
    public abstract void onChangeNotification(String receivingHeiId, Collection<String> outgoingMobilityIds);

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
