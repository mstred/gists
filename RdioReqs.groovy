String.metaClass.urlr = { java.net.URLEncoder.encode(delegate, 'UTF-8') }

def RdioReqs = { p0, p1, p2, p4, req_no ->
    p0 = p0.urlr(); p1 = p1.urlr(); p2 = p2.urlr(); p4 = p4.urlr()
    def urlString = "https://docs.google.com/spreadsheet/formResponse?formkey=dF9qNWcxT0pOLUlVQnVIbmxHX1ZuRlE6MQ&ifq"
    def queryString = "entry.0.single=${p0}&entry.1.single=${p1}&entry.2.single=${p2}&entry.4.single=${p4}&pageNumber=0&backupCache=&submit=Enviar"
    def url = new URL(urlString)
    def connection, writer, response
    
    req_no.times({
        connection = url.openConnection(); connection.setRequestMethod("POST"); connection.doOutput = true
        
        writer = new OutputStreamWriter(connection.outputStream)
        writer.write(queryString); writer.flush(); writer.close()
        connection.connect()
        
        response = connection.content.text
        println response.contains("Obrigado!") ? "Obrigado! ${it + 1} pedido(s) registrado(s) para: {${p0}, ${p1}, ${p2}, ${p4}}" : "Xii..."
        connection = writer = response = null
    })
}

def artist     = ""
def album      = ""
def label      = ""
def country    = ""
def no_of_reqs = 0

RdioReqs (artist, album, label, country, 100)