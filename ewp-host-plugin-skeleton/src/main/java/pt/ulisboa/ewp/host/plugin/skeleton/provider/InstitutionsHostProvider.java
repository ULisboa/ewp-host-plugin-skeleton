package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import eu.erasmuswithoutpaper.api.institutions.InstitutionsResponse;

/**
 * A provider that allows EWP Node to obtain institutions data from the host.
 */
public abstract class InstitutionsHostProvider extends HostProvider {

  /**
   * Returns the institution data for a given HEI ID.
   * If the plugin cannot resolve the HEI ID then it must return null.
   *
   * @param heiId HEI ID of the institution
   * @return Institution data.
   */
  public abstract InstitutionsResponse.Hei findByHeiId(String heiId);
}
