package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities.las;

import eu.erasmuswithoutpaper.api.omobilities.las.v1.endpoints.LasOutgoingStatsResponseV1;
import eu.erasmuswithoutpaper.api.omobilities.las.v1.endpoints.OmobilityLasUpdateResponseV1;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Nullable;

import eu.erasmuswithoutpaper.api.omobilities.las.v1.endpoints.LearningAgreementV1;
import eu.erasmuswithoutpaper.api.omobilities.las.v1.endpoints.OmobilityLasUpdateRequestV1;
import pt.ulisboa.ewp.host.plugin.skeleton.exceptions.EditConflictException;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Outgoing Mobility Learning Agreements from the host (V1).
 */
public abstract class OutgoingMobilityLearningAgreementsV1HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of Outgoing Mobility IDs, that have learning agreements, which the receiving institution has access
     * to.
     *
     * Only learning agreements currently approved by the student and the sending HEI should be returned.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-las/blob/stable-v1/endpoints/index.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param sendingHeiId Identifier of the HEI which is the sending partner of the outgoing mobilities.
     * @param receivingHeiIds If not null, the list of returned Outgoing Mobility IDs must only include those mobilities whose
     *            receiving institution matches at least one of the given identifiers.
     * @param receivingAcademicYearId If not null, the list of returned Outgoing Mobility IDs must only include those that are
     *            valid in the given academic years.
     * @param globalId Global student identifier. If not null, the list of returned Outgoing Mobility IDs must only include those
     *            mobilities that belong to the specified student.
     * @param mobilityType One of the following mobility types: blended, doctoral, semester. If not null, the list of returned
     *            Outgoing Mobility IDs must only include those mobilities only of the specified type..
     * @param modifiedSince If not null, the list of returned Outgoing Mobility IDs must only include those that have been either
     *            created or
     *            modified after the given point in time.
     * @return Collection of Outgoing Mobility IDs.
     */
    public abstract Collection<String> findOutgoingMobilityIds(Collection<String> requesterCoveredHeiIds, String sendingHeiId,
            Collection<String> receivingHeiIds, @Nullable String receivingAcademicYearId, @Nullable String globalId,
            @Nullable String mobilityType, @Nullable LocalDateTime modifiedSince);

    /**
     * Returns a collection of learning agreements given their outgoing mobility IDs.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-las/blob/stable-v1/endpoints/get.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param sendingHeiId HEI ID of the sending institution (mobilities' owner).
     * @param outgoingMobilityIds Outgoing Mobilities IDs to obtain. If some ID is unknown then it must be ignored.
     * @return Collection of learning agreements.
     */
    public abstract Collection<LearningAgreementV1> findBySendingHeiIdAndOutgoingMobilityIds(
            Collection<String> requesterCoveredHeiIds, String sendingHeiId, Collection<String> outgoingMobilityIds);

    /**
     * Comments or approves a Learning Agreement proposal.
     *
     * It must throw an EditConflictException if some edit conflict is detected.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-las/blob/stable-v1/endpoints/update.md">EWP
     *      Specification</a>
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the mobilities
     *            to which some covered HEI ID has access to.
     * @param updateData Update data (@see <a href=
     *            "https://github.com/erasmus-without-paper/ewp-specs-api-omobility-las/blob/stable-v1/endpoints/update-request.xsd">EWP
     *            Specification</a>)
     * @throws EditConflictException Thrown if some conflict is detected when processing the update request.
     *             See <a href=
     *             "https://github.com/erasmus-without-paper/ewp-specs-api-omobility-las/blob/stable-v1/endpoints/update.md">EWP
     *             Specification</a> for details on possible conflicts.
     */
    public abstract OmobilityLasUpdateResponseV1 updateOutgoingMobilityLearningAgreement(Collection<String> requesterCoveredHeiIds,
            OmobilityLasUpdateRequestV1 updateData) throws EditConflictException;

    public abstract LasOutgoingStatsResponseV1 getStats();

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
        return "1.2.0";
    }
}
