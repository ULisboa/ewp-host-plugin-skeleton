package pt.ulisboa.ewp.host.plugin.skeleton.provider.omobilities.stats;

import eu.erasmuswithoutpaper.api.omobilities.stats.v1.OmobilityStatsResponseV1;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to get statistics describing outgoing mobilities from the sending
 * HEI.
 */
public abstract class OutgoingMobilityStatsV1HostProvider extends HostVersionedProvider {

  /**
   * Returns the statistics describing outgoing mobilities from the sending HEI.
   *
   * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-omobility-stats">EWP
   *     Specification</a>
   * @param sendingHeiId Identifier of the intended sending HEI from which the statistics are to be
   *     returned.
   */
  public abstract OmobilityStatsResponseV1 getStats(String sendingHeiId);

  @Override
  public String getVersion() {
    return "1.0.0";
  }
}
