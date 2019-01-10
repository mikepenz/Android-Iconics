import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.devicon_typeface_library.DevIcon;
import com.mikepenz.entypo_typeface_library.Entypo;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.foundation_icons_typeface_library.FoundationIcons;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.ionicons_typeface_library.Ionicons;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.meteocons_typeface_library.Meteoconcs;
import com.mikepenz.octicons_typeface_library.Octicons;
import com.mikepenz.pixeden_7_stroke_typeface_library.Pixeden7Stroke;
import com.mikepenz.typeicons_typeface_library.Typeicons;
import com.mikepenz.weather_icons_typeface_library.WeatherIcons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ru.ztrap.iconics.IconicsStringGenerator;

/**
 * @author pa.gulko zTrap (29.10.2017)
 */
@RunWith(JUnit4.class)
public class StringFieldsGenerator extends IconicsStringGenerator {

    @Test public void generateCommunityMaterial() throws Exception {
        generateIconsFrom(new CommunityMaterial());        
    }

    @Test public void generateDevIcon() throws Exception {
        generateIconsFrom(new DevIcon());        
    }

    @Test public void generateEntypo() throws Exception {
        generateIconsFrom(new Entypo());
    }

    @Test public void generateFontAwesome() throws Exception {
        generateIconsFrom(new FontAwesome());
    }

    @Test public void generateFoundationIcons() throws Exception {
        generateIconsFrom(new FoundationIcons());
    }

    @Test public void generateGoogleMaterial() throws Exception {
        generateIconsFrom(new GoogleMaterial());
    }

    @Test public void generateIonicons() throws Exception {
        generateIconsFrom(new Ionicons());
    }

    @Test public void generateMaterialDesignIconic() throws Exception {
        generateIconsFrom(new MaterialDesignIconic());
    }

    @Test public void generateMeteoconcs() throws Exception {
        generateIconsFrom(new Meteoconcs());
    }

    @Test public void generateOcticons() throws Exception {
        generateIconsFrom(new Octicons());
    }

    @Test public void generatePixeden7Stroke() throws Exception {
        generateIconsFrom(new Pixeden7Stroke());
    }

    @Test public void generateTypeicons() throws Exception {
        generateIconsFrom(new Typeicons());
    }

    @Test public void generateWeatherIcons() throws Exception {
        generateIconsFrom(new WeatherIcons());
    }

    @Override protected FileCreationStrategy fileCreationStrategy() {
        return FileCreationStrategy.SAVE_ONLY_CURRENT;
    }

    @Override protected String modifierCurrent() {
        return "";
    }
}
