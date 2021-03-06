// Load the PDF document created by SimpleForm.java
PDDocument document = PDDocument.load(new File("target/SimpleForm.pdf"));
PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

// Get the field and the widget associated to it.
// Note: there might be multiple widgets
PDField field = acroForm.getField("SampleField");
PDAnnotationWidget widget = field.getWidgets().get(0);

// Get the width of the fields box
float widthOfField = widget.getRectangle().getWidth();

// Get the font and the font size setting
// This is currently a little awkward and needs improvement to have a better API
// for that. In many cases the string will be built like that:
// /Helv 12 Tf 0 g
// We could use PDFStreamParser to do the parsing. For the sample we split the
// string.
String defaultAppearance = ((PDTextField) field).getDefaultAppearance();
String[] parts = defaultAppearance.split(" ");

// Get the font name
COSName fontName = COSName.getPDFName(parts[0].substring(1));
float fontSize = Float.parseFloat(parts[1]);

// Get the font resource.
// First look up the font from the widgets appearance stream.
// This will be the case if there is already a value.
// If the value hasn't been set yet the font resource needs to be looked up from
// the AcroForm default resources

PDFont font = null;
PDResources resources = null;

resources = widget.getNormalAppearanceStream().getResources();
if (resources != null)
{
font = resources.getFont(fontName);
}
if (font == null)
{
font = acroForm.getDefaultResources().getFont(fontName);
}

String willFit = "short string";
String willNotFit = "this is a very long string which will not fit the width of the widget";

// calculate the string width at a certain font size
float willFitWidth = font.getStringWidth(willFit) * fontSize / 1000;
float willNotFitWidth = font.getStringWidth(willNotFit) * fontSize / 1000;

assert willFitWidth < widthOfField;
assert willNotFitWidth > widthOfField;

document.close();
