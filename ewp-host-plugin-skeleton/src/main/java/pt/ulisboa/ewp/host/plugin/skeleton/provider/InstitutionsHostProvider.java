package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import java.util.Optional;

import eu.erasmuswithoutpaper.api.institutions.InstitutionsResponse.Hei;

/**
 * A provider that allows EWP Node to obtain institutions data from the host.
 */
public abstract class InstitutionsHostProvider extends HostProvider {

  /**
   * Returns the institution data for a given HEI ID.
   * If the plugin cannot resolve the HEI ID then it must return an empty optional.
   *
   * @param heiId HEI ID of the institution
   * @return Optional with Institution data or empty, if unknown HEI ID.
   */
  public abstract Optional<Hei> findByHeiId(String heiId);
}
