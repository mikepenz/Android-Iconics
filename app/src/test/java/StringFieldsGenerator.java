import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.devicon_typeface_library.DevIcon;
import com.mikepenz.entypo_typeface_library.Entypo;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.foundation_icons_typeface_library.FoundationIcons;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.typeface.ITypeface;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author pa.gulko zTrap (29.10.2017)
 */
@RunWith(JUnit4.class)
public class StringFieldsGenerator {
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("(?=\\p{Lu})");
    private static final String WORD_DELIMITER = "_";
    private static final String MODIFIER_CURRENT = "_current_";
    private static final String DIRECTORY_NAME = "FONT_IDS";
    private static final String XML = "xml";

    @Test
    public void generateCommunityMaterial() throws Exception {
        generate(new CommunityMaterial());        
    }

    @Test
    public void generateDevIcon() throws Exception {
        generate(new DevIcon());        
    }

    @Test
    public void generateEntypo() throws Exception {
        generate(new Entypo());
    }

    @Test
    public void generateFontAwesome() throws Exception {
        generate(new FontAwesome());
    }

    @Test
    public void generateFoundationIcons() throws Exception {
        generate(new FoundationIcons());
    }

    @Test
    public void generateGoogleMaterial() throws Exception {
        generate(new GoogleMaterial());
    }

    @Test
    public void generateIonicons() throws Exception {
        generate(new Ionicons());
    }

    @Test
    public void generateMaterialDesignIconic() throws Exception {
        generate(new MaterialDesignIconic());
    }

    @Test
    public void generateMeteoconcs() throws Exception {
        generate(new Meteoconcs());
    }

    @Test
    public void generateOcticons() throws Exception {
        generate(new Octicons());
    }

    @Test
    public void generatePixeden7Stroke() throws Exception {
        generate(new Pixeden7Stroke());
    }

    @Test
    public void generateTypeicons() throws Exception {
        generate(new Typeicons());
    }

    @Test
    public void generateWeatherIcons() throws Exception {
        generate(new WeatherIcons());
    }

    private void generate(ITypeface typeface) throws Exception {
        final String handledClassName = handleWords(typeface.getFontName()) + "_v";

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        Element resources = doc.createElement("resources");
        doc.appendChild(resources);

        for (String icon : typeface.getIcons()) {
            Element iconElement = doc.createElement("string");
            iconElement.setAttribute("name", icon);
            iconElement.setTextContent(icon);
            resources.appendChild(iconElement);
        }

        String fileName = handledClassName + typeface.getVersion() + "." + XML;

        //region renaming old file
        File fontDirectory = new File(DIRECTORY_NAME);
        File[] files = fontDirectory.listFiles(file ->
                file.getName().matches(MODIFIER_CURRENT + handledClassName + ".+\\." + XML));

        if (files.length > 0){
            File current = files[0];
            File renamed = new File(fontDirectory, current.getName().replace(MODIFIER_CURRENT, ""));
            if (!current.renameTo(renamed)) {
                throw new IllegalArgumentException("Unable to rename file from " + current.getName() + " to "
                        + renamed.getName() + ". Probably file " + renamed.getName() + " is already exist.");
            }
        }
        //endregion

        File newFile = new File(fontDirectory, MODIFIER_CURRENT + fileName);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        transformer.transform(new DOMSource(doc), new StreamResult(newFile));
    }

    private String handleWords(String fieldName) {
        fieldName = fieldName.replace(" ", "");
        String[] words = UPPERCASE_PATTERN.split(fieldName);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(WORD_DELIMITER);
            }
            sb.append(word.toLowerCase());
        }
        return sb.toString();
    }
}
