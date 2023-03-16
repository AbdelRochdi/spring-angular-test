package lu.atozdigital.api.shared.configuration;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.dtos.OnlineOrderDTO;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.models.OnlineOrder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        configureCollectionFieldMappings(modelMapper);

        return modelMapper;
    }

    private void configureCollectionFieldMappings(ModelMapper modelMapper) {
        Converter<List<Integer>, Set<Article>> idsToArticlesConverter = context -> ofNullable(context.getSource()).stream()
                .flatMap(Collection::stream).map(Article::new).collect(Collectors.toSet());
        Converter<Set<Article>, List<Integer>> articlesToIdsConverter = context -> context.getSource().stream()
                .map(Article::getId).toList();

        Converter<byte[], String> bytesToStringConverter = context -> Base64.getEncoder()
                .encodeToString(ofNullable(context.getSource()).orElseGet(() -> new byte[]{}));

        modelMapper.typeMap(OnlineOrderDTO.class, OnlineOrder.class).addMappings(mapper -> {
                    mapper.using(idsToArticlesConverter).map(OnlineOrderDTO::getArticleIds, OnlineOrder::setArticles);
                    mapper.skip(OnlineOrder::setId);
                    mapper.skip(OnlineOrder::setReference);
                }
        );
        modelMapper.typeMap(OnlineOrder.class, OnlineOrderDTO.class).addMappings(mapper ->
                mapper.using(articlesToIdsConverter).map(OnlineOrder::getArticles, OnlineOrderDTO::setArticleIds));

        modelMapper.typeMap(Article.class, ArticleDTO.class).addMappings(mapper ->
                mapper.using(bytesToStringConverter).map(Article::getImage, ArticleDTO::setImage));

    }


}
