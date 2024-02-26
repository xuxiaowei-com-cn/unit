package cn.com.xuxiaowei.utils.unit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author xuxiaowei
 * @since 0.0.1
 */
class DataSizeTests {

    @Test
    void toStringUnit() {
        assertThat(DataSize.ofBytes(-123456).toStringUnit()).isEqualTo("-123456B");

        assertThat(DataSize.ofBytes(0).toStringUnit()).isEqualTo("0B");

        assertThat(DataSize.ofBytes(1_000).toStringUnit()).isEqualTo("1000B");
        assertThat(DataSize.ofBytes(10_000).toStringUnit()).isEqualTo("9K");
        assertThat(DataSize.ofBytes(10_000_000).toStringUnit()).isEqualTo("9M");
        assertThat(DataSize.ofGigabytes(1_000).toStringUnit()).isEqualTo("1000G");
        assertThat(DataSize.ofGigabytes(1_000_000).toStringUnit()).isEqualTo("976T");
    }

    @Test
    void toStringLongUnit() {
        assertThat(DataSize.ofBytes(-123456).toStringLongUnit()).isEqualTo("-120K576B");

        assertThat(DataSize.ofBytes(0).toStringLongUnit()).isEqualTo("0B");

        assertThat(DataSize.ofBytes(1L).toStringLongUnit()).isEqualTo("1B");

        assertThat(DataSize.ofBytes(2L * 1024).toStringLongUnit()).isEqualTo("2K");
        assertThat(DataSize.ofBytes(2L * 1024 + 1).toStringLongUnit()).isEqualTo("2K1B");

        assertThat(DataSize.ofBytes(3L * 1024 * 1024).toStringLongUnit()).isEqualTo("3M");
        assertThat(DataSize.ofBytes(3L * 1024 * 1024 + 1).toStringLongUnit()).isEqualTo("3M1B");
        assertThat(DataSize.ofBytes(3L * 1024 * 1024 + 2L * 1024).toStringLongUnit()).isEqualTo("3M2K");
        assertThat(DataSize.ofBytes(3L * 1024 * 1024 + 2L * 1024 + 1).toStringLongUnit()).isEqualTo("3M2K1B");

        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024).toStringLongUnit()).isEqualTo("4G");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 1).toStringLongUnit()).isEqualTo("4G1B");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 2 * 1024).toStringLongUnit()).isEqualTo("4G2K");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 3 * 1024 * 1024).toStringLongUnit()).isEqualTo("4G3M");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 3 * 1024 * 1024 + 1).toStringLongUnit()).isEqualTo("4G3M1B");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 3 * 1024 * 1024 + 2 * 1024).toStringLongUnit()).isEqualTo("4G3M2K");
        assertThat(DataSize.ofBytes(4L * 1024 * 1024 * 1024 + 3 * 1024 * 1024 + 2 * 1024 + 1).toStringLongUnit()).isEqualTo("4G3M2K1B");

        assertThat(DataSize.ofBytes(5L * 1024 * 1024 * 1024 * 1024).toStringLongUnit()).isEqualTo("5T");
        assertThat(DataSize.ofBytes(5L * 1024 * 1024 * 1024 * 1024 + 1).toStringLongUnit()).isEqualTo("5T1B");
        assertThat(DataSize.ofBytes(5L * 1024 * 1024 * 1024 * 1024 + 2 * 1024).toStringLongUnit()).isEqualTo("5T2K");
        assertThat(DataSize.ofBytes(5L * 1024 * 1024 * 1024 * 1024 + 3 * 1024 * 1024).toStringLongUnit()).isEqualTo("5T3M");
        assertThat(DataSize.ofBytes(5L * 1024 * 1024 * 1024 * 1024 + 4L * 1024 * 1024 * 1024).toStringLongUnit()).isEqualTo("5T4G");
    }

}
