<%-- 
    Document   : companheiro
    Created on : 28/04/2020, 20:07:28
    Author     : gustavo
--%>

<div class="modal modal1 fade bd-example-modal-lg2 fundo" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enviar para Companheiro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <button class="btn btn-primary form-control" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                Vídeo
                            </button>
                        </div>
                        <div class="col-md-6">
                            <button class="btn btn-primary form-control" type="button" data-toggle="collapse" data-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">
                                PDF
                            </button>
                        </div>
                    </div>
                    <div class="collapse" id="collapseExample">
                        <form action="${pageContext.request.contextPath}/UploadCompanheiroVideo" method="post"  enctype="multipart/form-data">
                            <div class="card">
                                <h5 class="text-left">Carregar Video</h5>
                                <div class="card-body">
                                    <input type="file" class="form-control" name="file" class="btn btn-info"/><br>                                                         
                                    <button type="submit" class="btn btn-primary">Enviar</button>                                                        
                                </div>                                                    
                            </div>
                        </form>
                    </div>
                    <div class="collapse" id="collapseExample1">
                        <form action="${pageContext.request.contextPath}/UploadCompanheiroPDF" method="post"  enctype="multipart/form-data">
                            <div class="card">
                                <h5 class="text-left">Carregar PDF</h5>
                                <div class="card-body">
                                    <input type="file" class="form-control" name="file" class="btn btn-info"/><br>                                                         
                                    <button type="submit" class="btn btn-primary">Enviar</button>                                                        
                                </div>                                                    
                            </div>
                        </form> 
                    </div>
                </div> 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>                                         
            </div>                                 
        </div>
    </div>
</div> 