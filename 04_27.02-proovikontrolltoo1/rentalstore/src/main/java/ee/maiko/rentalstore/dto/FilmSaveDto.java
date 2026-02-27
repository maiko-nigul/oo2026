package ee.maiko.rentalstore.dto;

import ee.maiko.rentalstore.entity.FilmType;

public record FilmSaveDto(String title, FilmType type) {
}
