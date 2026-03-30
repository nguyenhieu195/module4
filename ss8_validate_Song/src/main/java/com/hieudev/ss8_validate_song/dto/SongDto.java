package com.hieudev.ss8_validate_song.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-\\+]*$", message = "Tên bài hát không chứa kí tự đặc biệt @ ; , . = - +")
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-\\+]*$", message = "Tên nghệ sĩ không chứa kí tự đặc biệt @ ; , . = - +")
    private String artist;

    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;.=\\-\\+]*$", message = "Thể loại nhạc chỉ được chứa dấu phẩy và các chữ, số")
    private String genre;
}