package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import java.util.Collection;

import eu.erasmuswithoutpaper.api.ounits.OunitsResponse.Ounit;

/**
 * A provider that allows EWP Node to obtain organizational units data from the host.
 */
public abstract class OrganizationalUnitsHostProvider extends HostProvider {

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
}
