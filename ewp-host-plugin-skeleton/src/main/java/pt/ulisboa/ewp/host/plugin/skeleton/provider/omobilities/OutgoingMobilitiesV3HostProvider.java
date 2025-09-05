package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities;

import eu.erasmuswithoutpaper.api.omobilities.v3.endpoints.OmobilitiesUpdateRequestV3;
import eu.erasmuswithoutpaper.api.omobilities.v3.endpoints.OmobilitiesUpdateResponseV3;
import eu.erasmuswithoutpaper.api.omobilities.v3.endpoints.StudentMobilityV3;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.annotation.Nullable;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/** A provider that allows EWP Node to obtain the list of Outgoing Mobilities from the host (V3). */
public abstract class OutgoingMobilitiesV3HostProvider extends HostVersionedProvider {

  private static final int DEFAULT_MAX_NUMBER_OUTGOING_MOBILITY_IDS_PER_REQUEST = 1;

  /**
   * Returns a collection of Outgoing Mobility IDs which the requester has access to.
   *
   * @param requesterCoveredHeiId HEI ID of the requester. The result should be restricted to the
   *     mobilities to which that HEI ID has access to.
   * @param sendingHeiId Identifier of the HEI which is the sending partner of the outgoing
   *     mobilities.
   * @param receivingAcademicYearId If not null, the list of returned Outgoing Mobility IDs must
   *     only include those that are valid in the given academic years.
   * @param modifiedSince If not null, the list of returned Outgoing Mobility IDs must only include
   *     those that have been either created or modified after the given point in time.
   * @param globalId If not null, a global identifier of a student. If given, then the list of
   *     returned Outgoing Mobility IDs must only include those that belong to that student.
   * @param activityAttributes If not null, an activity attribute (mobility type) of mobility. If
   *     given, then the list of returned Outgoing Mobility IDs must only include those mobilities
   *     with that activity attribute value.
   * @return Collection of Outgoing Mobility IDs.
   */
  public abstract Collection<String> findOutgoingMobilityIds(
      String requesterCoveredHeiId,
      String sendingHeiId,
      @Nullable String receivingAcademicYearId,
      @Nullable LocalDateTime modifiedSince,
      @Nullable String globalId,
      @Nullable String activityAttributes);

  /**
   * Returns a collection of Outgoing Mobilities given their IDs. If some ID is unknown then it must
   * be ignored.
   *
   * @param requesterCoveredHeiId HEI ID of the requester. The result should be restricted to * the
   *     mobilities to which that HEI ID has access to.
   * @param sendingHeiId HEI ID of the sending institution.
   * @param outgoingMobilityIds Outgoing Mobilities IDs to obtain.
   * @return Collection of Outgoing Mobilities.
   */
  public abstract Collection<StudentMobilityV3> findBySendingHeiIdAndOutgoingMobilityIds(
      String requesterCoveredHeiId, String sendingHeiId, Collection<String> outgoingMobilityIds);

  /**
   * Returns a collection of Outgoing Mobilities given their IDs. If some ID is unknown then it must
   * be ignored.
   *
   * @param requesterCoveredHeiId HEI ID of the requester. The result should be restricted to * the
   *     mobilities to which that HEI ID has access to.
   * @param sendingHeiId HEI ID of the sending institution.
   * @param updateData Update data.
   * @return Collection of Outgoing Mobilities.
   */
  public abstract OmobilitiesUpdateResponseV3 updateOutgoingMobility(
      String requesterCoveredHeiId, String sendingHeiId, OmobilitiesUpdateRequestV3 updateData);

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
    return "3.0.0";
  }
}
