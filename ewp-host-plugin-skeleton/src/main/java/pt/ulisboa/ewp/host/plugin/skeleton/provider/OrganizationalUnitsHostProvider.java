package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import java.util.Collection;

import eu.erasmuswithoutpaper.api.ounits.v2.OunitsResponseV2.Ounit;

/**
 * A provider that allows EWP Node to obtain organizational units data from the host.
 */
public abstract class OrganizationalUnitsHostProvider extends HostProvider {

  private static final int DEFAULT_MAX_NUMBER_OUNIT_IDS_PER_REQUEST = 1;
  private static final int DEFAULT_MAX_NUMBER_OUNIT_CODES_PER_REQUEST = 1;

  /**
   * Returns a collection of organizational units given their IDs.
   * If some ID is unknown then it must be ignored.
   *
   * @param heiId HEI ID of the institution that contains the intended organizational units.
   * @param ounitIds Organizational Unit IDs to obtain
   * @return Collection of organizational units
   */
  public abstract Collection<Ounit> findByHeiIdAndOunitIds(String heiId, Collection<String> ounitIds);

  /**
   * Returns a collection of organizational units given their codes.
   * If some code is unknown then it must be ignored.
   *
   * @param heiId HEI ID of the institution that contains the intended organizational units.
   * @param ounitCodes Organizational Unit codes to obtain
   * @return Collection of organizational units
   */
  public abstract Collection<Ounit> findByHeiIdAndOunitCodes(String heiId, Collection<String> ounitCodes);

  /**
   * Indicates the maximum number of organizational unit IDs that can be handled on any request.
   * @return Maximum number of organizational unit IDs
   */
  public int getMaxOunitIdsPerRequest() {
    return DEFAULT_MAX_NUMBER_OUNIT_IDS_PER_REQUEST;
  }

  /**
   * Indicates the maximum number of organizational unit codes that can be handled on any request.
   * @return Maximum number of organizational unit codes
   */
  public int getMaxOunitCodesPerRequest() {
    return DEFAULT_MAX_NUMBER_OUNIT_CODES_PER_REQUEST;
  }

  @Override
  public String getVersion() {
    return "2.1.1";
  }
}
