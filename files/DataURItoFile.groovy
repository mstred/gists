def path = "" //path to input file directory
def input = new File("${path}/file.png") //example
def mime = new javax.activation.MimetypesFileTypeMap().getContentType(input)
def content = "data:${mime};base64,${input.bytes.encodeBase64().toString()}"
def output = new java.io.FileWriter("${path}/${input.name}.datauri")
def info = "${input.name} -> ${((input.size() / 1024f) / 1024f)} MB \nMime-type: ${mime}"
println info
output.write(content)
output.close()

/* Clipboard
java.awt.Toolkit.defaultToolkit.systemClipboard.setContents(new java.awt.datatransfer.StringSelection(content), null) */