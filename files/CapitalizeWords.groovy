String.metaClass.capitalizeWords = {
    delegate.toLowerCase().split(' ').collect{ 
        (!it.matches("da|de|do")) ? it.capitalize() : it }.join(' ')
}

'RIO GRANDE DO SUL'.capitalizeWords()
'MINAS GERAIS'.capitalizeWords()