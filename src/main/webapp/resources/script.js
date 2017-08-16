function validateOrderForm()
{
    var counter = $("#list_Products").children().length;
    alert(counter);
    if(counter >= 1)
        return true
    else
    {
     //alert("You must select at least one item");
     return false;
    }
}