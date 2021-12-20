package pt.ulisboa.ewp.host.plugin.skeleton.provider.imobilities;

import java.util.Collection;

import eu.erasmuswithoutpaper.api.imobilities.v1.endpoints.ImobilitiesGetResponseV1;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Incoming Mobilities from the host (V1).
 */
public abstract class IncomingMobilitiesV1HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of Incoming Mobilities given their outgoing mobility IDs.
     * If some ID is unknown then it must be ignored.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-imobilities/blob/stable-v1/endpoints/get.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param receivingHeiId HEI ID of the receiving institution.
     * @param outgoingMobilityIds Outgoing Mobilities IDs to obtain.
     * @return Collection of Incoming Mobilities.
     */
    public abstract Collection<ImobilitiesGetResponseV1> findByReceivingHeiIdAndOutgoingMobilityIds(
            Collection<String> requesterCoveredHeiIds, String receivingHeiId, Collection<String> outgoingMobilityIds);

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
