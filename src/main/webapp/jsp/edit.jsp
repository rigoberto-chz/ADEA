<title>Editar</title>
<link rel="stylesheet" type="text/css" href="css/style-formulario.css"/>
</head>
<body>  
  <div class="contact_form">

    <div class="formulario">      
      <h1>Formulario de edición</h1>
          <form action="save.htm" method="post">
            
                <p>
                  <label for="nombre">Login
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_login" id="login" required="obligatorio" placeholder="Escribe tu login" value="${usuario.login}">
                </p>
                
                <p>
                  <label for="nombre">Password
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_password" id="password" required="obligatorio" placeholder="Escribe tu password" value="${usuario.password}">
                </p>
                
                <p>
                  <label for="nombre">Nombre
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_nombre" id="nombre" required="obligatorio" placeholder="Escribe tu nombre" value="${usuario.nombre}">
                </p>
                
                <p>
                  <label for="nombre">Cliente
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_cliente" id="cliente" required="obligatorio" placeholder="Escribe tu cliente" value="${usuario.cliente}">
                </p>
                
                <p>
                  <label for="nombre">Email</label>
                    <input type="text" name="introducir_email" id="email" placeholder="Escribe tu Email" value="${usuario.email}">
                </p>
                
                <p>
                  <label for="nombre">Fecha Alta
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_fechaalta" id="fechaalta" required="obligatorio" placeholder="Escribe tu Fecha Alta" value="${usuario.fechaAlta}">
                </p>
                
                <p>
                  <label for="nombre">Fecha Baja</label>
                    <input type="text" name="introducir_fechabaja" id="fechabaja" placeholder="Escribe tu Fecha Baja" value="${usuario.fechaBaja}">
                </p>
                
                <p>
                  <label for="nombre">Status
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_status" id="status" required="obligatorio" placeholder="Escribe tu status" value="${usuario.status}">
                </p>
                
                <p>
                  <label for="nombre">Intentos
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_intentos" id="intentos" required="obligatorio" placeholder="Escribe tu intentos" value="${usuario.intentos}">
                </p>
                
                <p>
                  <label for="nombre">Fecha Revocado</label>
                    <input type="text" name="introducir_fecharevocado" id="fecharevocado" placeholder="Escribe tu Fecha Revocado" value="${usuario.fechaRevocado}">
                </p>
                
                <p>
                  <label for="nombre">Fecha Vigencia</label>
                    <input type="text" name="introducir_fechavigencia" id="fechavigencia" placeholder="Escribe tu Fecha Vigencia" value="${usuario.fechaVigencia}">
                </p>
              
              	<p>
                  <label for="nombre">No Acceso</label>
                    <input type="text" name="introducir_noacceso" id="noacceso" placeholder="Escribe tu No Acceso" value="${usuario.noAcceso}">
                </p>
                
                <p>
                  <label for="nombre">Apellido Paterno</label>
                    <input type="text" name="introducir_apellidopaterno" id="apellidopaterno" placeholder="Escribe tu Apellido Paterno" value="${usuario.apellidoPaterno}">
                </p>
                
                <p>
                  <label for="nombre">Apellido Materno</label>
                    <input type="text" name="introducir_apellidomaterno" id="apellidopatenro" placeholder="Escribe tu Apellido Paterno" value="${usuario.apellidoMaterno}">
                </p>
                
                <p>
                  <label for="nombre">Area</label>
                    <input type="text" name="introducir_area" id="area" placeholder="Escribe tu Area" value="${usuario.area}">
                </p>
                
                <p>
                  <label for="nombre">Fecha Modificación
                    <span class="obligatorio">*</span>
                  </label>
                    <input type="text" name="introducir_fechamodificacion" id="fechamodificacion" required="obligatorio" placeholder="Escribe tu Fecha Modificación" value="${usuario.fechaModificacion}">
                </p>              
              
                <button type="submit" name="enviar_formulario" id="enviar"><p>Enviar</p></button>

                <p class="aviso">
                  <span class="obligatorio"> * </span>los campos son obligatorios.
                </p>          
            
          </form>
    </div>  
  </div>

</body>


</html>