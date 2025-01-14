package syncdata.sdt.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import syncdata.sdt.business.entities.Buy;

public interface BuyRepository extends JpaRepository<Buy,Long> {
    /*@Query("SELECT new com.mimp.smpt.dtos.SmptDocumentoDTOResultado("
            + "docs.smptInstanciaProceso.idInstanciaProceso, docs.idDocumento, docs.feDocumento, subcat.deSubcatDocumento, cat.deCategoriaDocumento "
            + ", docs.deAsunto, subcat.idSubcatDocumento " //, ori.noValorParametro,docs.seDocumento
            + ",fp.idFaseProceso,fp.noFaseProceso,fp.deFaseProceso " //,subcat.flNumeradoPorSiged
            + ",docs.coDocumento,docs.noOriginalArchivo,docs.clArchivo "
            + ",docs.flProyecto, docs.smptExpediente.idExpediente, docs.flEnProcesoAprobacion) "
            + "FROM SmptDocumento docs "
            + ", SmptInstanciaProceso inspro "
            + ", SmptSubcategoriaDoc subcat "
            + ", SmptCategoriaDoc cat "
            //+ ", SmptValorParametro ori "
            + ", SmptFaseProceso fp "
            + "WHERE docs.smptInstanciaProceso = inspro AND docs.smptSubcategoriaDoc = subcat AND subcat.smptCategoriaDoc=cat "
            + "AND docs.smptFaseProceso.idFaseProceso= fp.idFaseProceso "
            //+ "AND docs.tipoOrigenDocumento = ori "
            + "AND docs.esRegistro = '1' and inspro.esRegistro = '1' "
            + "AND inspro.idInstanciaProceso = :idInstanciaProceso " )
    Buy obtenerDocumentosInstancia(@Param("idInstanciaProceso") Long idInstanciaProceso, Sort sort);
    */
}

