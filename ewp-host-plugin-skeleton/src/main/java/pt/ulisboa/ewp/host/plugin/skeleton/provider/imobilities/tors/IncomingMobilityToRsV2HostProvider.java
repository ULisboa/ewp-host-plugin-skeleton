package pt.ulisboa.ewp.host.plugin.skeleton.provider.imobilities.tors;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Nullable;

import eu.erasmuswithoutpaper.api.imobilities.tors.v2.endpoints.ImobilityTorsGetResponseV2;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Incoming Mobility Transcripts of Records from the host (V2).
 */
public abstract class IncomingMobilityToRsV2HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of Outgoing Mobility IDs, which the receiving institution has already attached corresponding
     * Transcripts Records.
     *
     * Only ToRs approved as "ready for recognition" should be returned.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-imobility-tors/blob/stable-v2/endpoints/index.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the Transcripts
     *            of Record to which some covered HEI ID has access to.
     * @param receivingHeiId Identifier of the HEI which is the receiving partner of the mobilities, and the issuer of the
     *            returned Transcripts of Records.
     * @param sendingHeiIds If not null, the list of returned mobility IDs must only include those mobilities whose sending
     *            institution matches at least one of the given identifiers.
     * @param modifiedSince If not null, the list of returned mobility IDs must only include those whose transcript of record have
     *            been either created or modified after the given point in time.
     * @return Collection of Outgoing Mobility IDs.
     */
    public abstract Collection<String> findOutgoingMobilityIds(Collection<String> requesterCoveredHeiIds, String receivingHeiId,
            Collection<String> sendingHeiIds, @Nullable LocalDateTime modifiedSince);

    /**
     * Returns a collection of Transcripts of Records given their mobility IDs.
     *
     * Only ToRs approved as "ready for recognition" should be returned.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-imobility-tors/blob/stable-v2/endpoints/get.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the Transcripts
     *            of Record to which some covered HEI ID has access to.
     * @param receivingHeiId HEI ID of the receiving institution.
     * @param outgoingMobilityIds Outgoing Mobilities IDs for which the client wants to retrieve corresponding Transcripts of
     *            Records. If some ID is unknown then it must be ignored.
     * @return Collection of Transcripts of Records.
     */
    public abstract Collection<ImobilityTorsGetResponseV2.Tor> findByReceivingHeiIdAndOutgoingMobilityIds(
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
        return "2.0.0";
    }
}
