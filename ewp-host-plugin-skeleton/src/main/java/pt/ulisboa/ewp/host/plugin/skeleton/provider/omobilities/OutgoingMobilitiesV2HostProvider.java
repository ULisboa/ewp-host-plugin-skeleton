package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Nullable;

import eu.erasmuswithoutpaper.api.omobilities.v2.endpoints.StudentMobilityV2;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Outgoing Mobilities from the host (V2).
 */
public abstract class OutgoingMobilitiesV2HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of Outgoing Mobility IDs which the requester has access to.
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param sendingHeiId Identifier of the HEI which is the sending partner of the outgoing mobilities.
     * @param receivingHeiIds If not null, the list of returned Outgoing Mobility IDs must only include those mobilities whose
     *            receiving institution matches at least one of the given identifiers.
     * @param receivingAcademicYearId If not null, the list of returned Outgoing Mobility IDs must only include those that are
     *            valid in the given academic years.
     * @param modifiedSince If not null, the list of returned Outgoing Mobility IDs must only include those that have been either
     *            created or
     *            modified after the given point in time.
     * @return Collection of Outgoing Mobility IDs.
     */
    public abstract Collection<String> findOutgoingMobilityIds(Collection<String> requesterCoveredHeiIds, String sendingHeiId, Collection<String> receivingHeiIds,
            @Nullable String receivingAcademicYearId, @Nullable LocalDateTime modifiedSince);

    /**
     * Returns a collection of Outgoing Mobilities given their IDs.
     * If some ID is unknown then it must be ignored.
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param sendingHeiId HEI ID of the sending institution.
     * @param outgoingMobilityIds Outgoing Mobilities IDs to obtain.
     * @return Collection of Outgoing Mobilities.
     */
    public abstract Collection<StudentMobilityV2> findBySendingHeiIdAndOutgoingMobilityIds(
            Collection<String> requesterCoveredHeiIds, String sendingHeiId, Collection<String> outgoingMobilityIds);

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
