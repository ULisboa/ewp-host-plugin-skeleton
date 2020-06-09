package pt.ulisboa.ewp.host.plugin.demo.providers;

import java.util.Optional;
import org.pf4j.Extension;

import pt.ulisboa.ewp.host.plugin.demo.DemoHostPlugin;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.InstitutionsHostProvider;
import eu.erasmuswithoutpaper.api.architecture.StringWithOptionalLang;
import eu.erasmuswithoutpaper.api.institutions.InstitutionsResponse;
import eu.erasmuswithoutpaper.api.institutions.InstitutionsResponse.Hei;

@Extension
public class DemoInstitutionsProvider extends InstitutionsHostProvider {

  @Override
  public Optional<InstitutionsResponse.Hei> findByHeiId(String heiId) {
    // Example: Obtain a property registered on EWP Node specific for the current plugin
    String propertyValue = DemoHostPlugin.getInstance().getProperties().getPropertyAsString("example.key");
    System.out.println("Obtained property value: " + propertyValue);

    if (heiId.equals("example.com")) {
      Hei hei = new Hei();
      hei.setHeiId("example.com");
      StringWithOptionalLang stringWithOptionalLang = new StringWithOptionalLang();
      stringWithOptionalLang.setLang("en");
      stringWithOptionalLang.setValue("Demo");
      hei.getName().add(stringWithOptionalLang);
      return Optional.of(hei);
    }
    return Optional.empty();
  }
}
