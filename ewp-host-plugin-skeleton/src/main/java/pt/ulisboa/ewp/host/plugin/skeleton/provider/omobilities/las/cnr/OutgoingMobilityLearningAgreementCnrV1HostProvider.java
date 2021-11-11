package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities.las.cnr;

import java.util.Collection;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to notify a host about a change notification on some outgoing mobility learning agreement (V1).
 */
public abstract class OutgoingMobilityLearningAgreementCnrV1HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Called when a change notification of an outgoing mobility learning agreement emitted by one of partner institutions.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-la-cnr/tree/stable-v1">EWP
     *      Specification</a>
     *
     * @param sendingHeiId Identifier of the HEI which is the sending partner of the outgoing mobility learning agreements that have been changed.
     * @param outgoingMobilityIds Outgoing Mobility (Learning Agreement) IDs that were changed.
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
