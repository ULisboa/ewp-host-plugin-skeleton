package pt.ulisboa.ewp.host.plugin.skeleton.provider.institutions;

import eu.erasmuswithoutpaper.api.institutions.v2.InstitutionsResponseV2.Hei;
import java.util.Optional;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain institutions data from the host (V2).
 */
public abstract class InstitutionsV2HostProvider extends HostVersionedProvider {

  /**
   * Returns the institution data for a given HEI ID.
   * If the plugin cannot resolve the HEI ID then it must return an empty optional.
   *
   * @param heiId HEI ID of the institution
   * @return Optional with Institution data or empty, if unknown HEI ID.
   */
  public abstract Optional<Hei> findByHeiId(String heiId);

  @Override
  public String getVersion() {
    return "2.1.0";
  }
}
