package com.gestordenotas.demo.services.impl;

import com.gestordenotas.demo.DTO.NotaDto;
import com.gestordenotas.demo.DTO.CreateNotaDto;
import com.gestordenotas.demo.entities.Nota;
import com.gestordenotas.demo.entities.Usuario;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.exceptions.InternalServerErrorException;
import com.gestordenotas.demo.exceptions.NotFoundException;
import com.gestordenotas.demo.repositories.NotaRepository;
import com.gestordenotas.demo.services.NotaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private UsuarioServiceIpml usuarioServiceIpml;


    @Autowired
    private NotaRepository notaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NotaDto createNota(CreateNotaDto createNotaDto) throws AqueHoraExceptions{
        Nota nota = new Nota();
        nota.setName_nota(createNotaDto.getName_nota());
        nota.setImportancia(createNotaDto.getImportancia());
        nota.setContenido(createNotaDto.getContenido());
        nota.setFecha_creacion(createNotaDto.getFecha_creacion());

        //Por ahora usuario Fijo para testear
        Usuario currentUsuario = new Usuario();
        try{
            currentUsuario = usuarioServiceIpml.getUsuarioEntity((long)9);
        } catch (Exception ex){
            //Checkear si es error correcto
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }
        nota.setUsuario(currentUsuario);

        try{
            nota=notaRepository.save(nota);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getNotaEntity(nota.getId()),NotaDto.class);
    }

    @Override
    public NotaDto updateNota(NotaDto notaDto) throws AqueHoraExceptions {
        return null;
    }

    /*
    @Transactional
    public Product save(Product product) {
        try {
            ProductValidator.save(product);

            if(product.getId() == null) {
                Product newProduct = productRepository.save(product);
                return newProduct;
            }

            Product exitProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));

            exitProduct.setName(product.getName());
            exitProduct.setPrice(product.getPrice());
            exitProduct.setCategory(product.getCategory());
            exitProduct.setDescription(product.getDescription());
            exitProduct.setStock(product.getStock());

            productRepository.save(exitProduct);

            return exitProduct;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }
     */

    public Nota getNotaEntity(Long notaId) throws AqueHoraExceptions {
        return notaRepository.findById(notaId).orElseThrow(() -> new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }
}
