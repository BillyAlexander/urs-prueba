let URL = 'http://localhost:8087/usr-distribution/distribution';

$(window).on('load', function() {
    loadProvincias();

  $('#provincia').on('change', function() {
    $('#parroquias').empty().append('<option>select</option>');  
    $('#canton').empty().append('<option>select</option>'); 
    loadCantones(this.value);
    verCodigo(this.value);
  });

  $('#canton').on('change', function() {
    $('#parroquias').empty().append('<option>select</option>');
    loadParroquias($('#provincia').val(),this.value);
    verCodigo($('#provincia').val()+' - '+this.value);
  });
  $('#parroquias').on('change', function() {

    verCodigo($('#provincia').val()+' - '+$('#canton').val()+' - '+this.value);
  });
  

});

function verCodigo(valor){
  var selected_option = $('#provincia').val();
  if($('#selected_option').val()==='select'){
    $('#vercodigos').text('')
  }else{
    $('#vercodigos').text(valor)
  }
  
}

 function loadProvincias()
{           
      $('#provincia').empty().append('<option>select</option>');   
           
      $.ajax({
              url: URL,
              dataType: 'json',
              type: 'GET',
              success: function(response) {
                var array = response;
                if (array != '')
                {
                  for (i in array) {                        
                  $("#provincia").append("<option value='"+array[i].code+"'>"+array[i].name+"</option>");
                }

                }

              },
              error: function(x, e) {

              }

          });
}



function loadCantones(provincia)
{           
      $('#canton').empty().append('<option>select</option>');  
          
      $.ajax({
              url: URL+"/"+provincia,
              dataType: 'json',
              type: 'GET',
              success: function(response) {
                console.log(response);
                var array = response;
                if (array != '')
                {
                  for (i in array) {                        
                  $("#canton").append("<option value='"+array[i].code+"'>"+array[i].name+"</option>");
                }

                }

              },
              error: function(x, e) {

              }

          });
}

function loadParroquias(provincia, canton)
{           
      $('#parroquias').empty().append('<option>select</option>');        
      $.ajax({
              url: URL+'/'+provincia+'/'+canton,
              dataType: 'json',
              type: 'GET',
              success: function(response) {
                var array = response;
                if (array != '')
                {
                  for (i in array) {                        
                  $("#parroquias").append("<option value='"+array[i].code+"'>"+array[i].name+"</option>");
                }

                }

              },
              error: function(x, e) {

              }

          });
}

