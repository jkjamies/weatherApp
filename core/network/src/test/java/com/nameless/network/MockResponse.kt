package com.nameless.network

val MOCK_FORECAST_RESPONSE = """
{
  "cod": "200",
  "message": 0,
  "cnt": 40,
  "list": [
    {
      "dt": 1663005600,
      "main": {
        "temp": 291.74,
        "feels_like": 291.67,
        "temp_min": 291.74,
        "temp_max": 294.65,
        "pressure": 1011,
        "sea_level": 1011,
        "grnd_level": 988,
        "humidity": 77,
        "temp_kf": -2.91
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 5.46,
        "deg": 217,
        "gust": 6.12
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-12 18:00:00"
    },
    {
      "dt": 1663016400,
      "main": {
        "temp": 292.79,
        "feels_like": 292.48,
        "temp_min": 292.79,
        "temp_max": 294.89,
        "pressure": 1010,
        "sea_level": 1010,
        "grnd_level": 987,
        "humidity": 64,
        "temp_kf": -2.1
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 83
      },
      "wind": {
        "speed": 5.76,
        "deg": 225,
        "gust": 7.11
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-12 21:00:00"
    },
    {
      "dt": 1663027200,
      "main": {
        "temp": 290.73,
        "feels_like": 290.14,
        "temp_min": 290.22,
        "temp_max": 290.73,
        "pressure": 1010,
        "sea_level": 1010,
        "grnd_level": 988,
        "humidity": 61,
        "temp_kf": 0.51
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 57
      },
      "wind": {
        "speed": 4.13,
        "deg": 243,
        "gust": 7.54
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-13 00:00:00"
    },
    {
      "dt": 1663038000,
      "main": {
        "temp": 288.81,
        "feels_like": 287.97,
        "temp_min": 288.81,
        "temp_max": 288.81,
        "pressure": 1009,
        "sea_level": 1009,
        "grnd_level": 988,
        "humidity": 59,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 72
      },
      "wind": {
        "speed": 3.14,
        "deg": 211,
        "gust": 5.57
      },
      "visibility": 10000,
      "pop": 0.05,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-13 03:00:00"
    },
    {
      "dt": 1663048800,
      "main": {
        "temp": 288.32,
        "feels_like": 287.75,
        "temp_min": 288.32,
        "temp_max": 288.32,
        "pressure": 1008,
        "sea_level": 1008,
        "grnd_level": 987,
        "humidity": 71,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 84
      },
      "wind": {
        "speed": 2.35,
        "deg": 182,
        "gust": 5.04
      },
      "visibility": 10000,
      "pop": 0.28,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-13 06:00:00"
    },
    {
      "dt": 1663059600,
      "main": {
        "temp": 287.22,
        "feels_like": 286.85,
        "temp_min": 287.22,
        "temp_max": 287.22,
        "pressure": 1007,
        "sea_level": 1007,
        "grnd_level": 986,
        "humidity": 83,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 1.78,
        "deg": 213,
        "gust": 3.75
      },
      "visibility": 10000,
      "pop": 0.59,
      "rain": {
        "3h": 0.74
      },
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-13 09:00:00"
    },
    {
      "dt": 1663070400,
      "main": {
        "temp": 287.11,
        "feels_like": 286.73,
        "temp_min": 287.11,
        "temp_max": 287.11,
        "pressure": 1008,
        "sea_level": 1008,
        "grnd_level": 986,
        "humidity": 83,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 2.03,
        "deg": 346,
        "gust": 4.38
      },
      "visibility": 10000,
      "pop": 0.59,
      "rain": {
        "3h": 0.66
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-13 12:00:00"
    },
    {
      "dt": 1663081200,
      "main": {
        "temp": 289.83,
        "feels_like": 289.22,
        "temp_min": 289.83,
        "temp_max": 289.83,
        "pressure": 1010,
        "sea_level": 1010,
        "grnd_level": 988,
        "humidity": 64,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 60
      },
      "wind": {
        "speed": 2.35,
        "deg": 311,
        "gust": 3.36
      },
      "visibility": 10000,
      "pop": 0.11,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-13 15:00:00"
    },
    {
      "dt": 1663092000,
      "main": {
        "temp": 294.3,
        "feels_like": 293.57,
        "temp_min": 294.3,
        "temp_max": 294.3,
        "pressure": 1009,
        "sea_level": 1009,
        "grnd_level": 988,
        "humidity": 42,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 62
      },
      "wind": {
        "speed": 2.5,
        "deg": 287,
        "gust": 3.43
      },
      "visibility": 10000,
      "pop": 0.08,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-13 18:00:00"
    },
    {
      "dt": 1663102800,
      "main": {
        "temp": 296.04,
        "feels_like": 295.35,
        "temp_min": 296.04,
        "temp_max": 296.04,
        "pressure": 1010,
        "sea_level": 1010,
        "grnd_level": 989,
        "humidity": 37,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03d"
        }
      ],
      "clouds": {
        "all": 42
      },
      "wind": {
        "speed": 3.71,
        "deg": 287,
        "gust": 4.33
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-13 21:00:00"
    },
    {
      "dt": 1663113600,
      "main": {
        "temp": 292.58,
        "feels_like": 291.83,
        "temp_min": 292.58,
        "temp_max": 292.58,
        "pressure": 1011,
        "sea_level": 1011,
        "grnd_level": 990,
        "humidity": 48,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03n"
        }
      ],
      "clouds": {
        "all": 39
      },
      "wind": {
        "speed": 2.49,
        "deg": 295,
        "gust": 5.11
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-14 00:00:00"
    },
    {
      "dt": 1663124400,
      "main": {
        "temp": 291.16,
        "feels_like": 290.5,
        "temp_min": 291.16,
        "temp_max": 291.16,
        "pressure": 1013,
        "sea_level": 1013,
        "grnd_level": 992,
        "humidity": 57,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 0
      },
      "wind": {
        "speed": 2.23,
        "deg": 272,
        "gust": 4.6
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-14 03:00:00"
    },
    {
      "dt": 1663135200,
      "main": {
        "temp": 290.06,
        "feels_like": 289.69,
        "temp_min": 290.06,
        "temp_max": 290.06,
        "pressure": 1014,
        "sea_level": 1014,
        "grnd_level": 992,
        "humidity": 72,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 0
      },
      "wind": {
        "speed": 2.6,
        "deg": 278,
        "gust": 7.35
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-14 06:00:00"
    },
    {
      "dt": 1663146000,
      "main": {
        "temp": 289.37,
        "feels_like": 289.32,
        "temp_min": 289.37,
        "temp_max": 289.37,
        "pressure": 1015,
        "sea_level": 1015,
        "grnd_level": 993,
        "humidity": 87,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 0
      },
      "wind": {
        "speed": 1.97,
        "deg": 279,
        "gust": 4.5
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-14 09:00:00"
    },
    {
      "dt": 1663156800,
      "main": {
        "temp": 289.28,
        "feels_like": 289.22,
        "temp_min": 289.28,
        "temp_max": 289.28,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 996,
        "humidity": 87,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 1
      },
      "wind": {
        "speed": 1.95,
        "deg": 281,
        "gust": 4.74
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-14 12:00:00"
    },
    {
      "dt": 1663167600,
      "main": {
        "temp": 295.75,
        "feels_like": 295.37,
        "temp_min": 295.75,
        "temp_max": 295.75,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 997,
        "humidity": 50,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 6
      },
      "wind": {
        "speed": 2.34,
        "deg": 287,
        "gust": 3.35
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-14 15:00:00"
    },
    {
      "dt": 1663178400,
      "main": {
        "temp": 300.35,
        "feels_like": 299.82,
        "temp_min": 300.35,
        "temp_max": 300.35,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 997,
        "humidity": 33,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "clouds": {
        "all": 17
      },
      "wind": {
        "speed": 3.69,
        "deg": 286,
        "gust": 5.12
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-14 18:00:00"
    },
    {
      "dt": 1663189200,
      "main": {
        "temp": 301.19,
        "feels_like": 300.48,
        "temp_min": 301.19,
        "temp_max": 301.19,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 996,
        "humidity": 34,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03d"
        }
      ],
      "clouds": {
        "all": 32
      },
      "wind": {
        "speed": 4.02,
        "deg": 299,
        "gust": 5.86
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-14 21:00:00"
    },
    {
      "dt": 1663200000,
      "main": {
        "temp": 294.73,
        "feels_like": 294.51,
        "temp_min": 294.73,
        "temp_max": 294.73,
        "pressure": 1019,
        "sea_level": 1019,
        "grnd_level": 997,
        "humidity": 60,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02n"
        }
      ],
      "clouds": {
        "all": 19
      },
      "wind": {
        "speed": 3.91,
        "deg": 58,
        "gust": 6.48
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-15 00:00:00"
    },
    {
      "dt": 1663210800,
      "main": {
        "temp": 291.33,
        "feels_like": 291.21,
        "temp_min": 291.33,
        "temp_max": 291.33,
        "pressure": 1021,
        "sea_level": 1021,
        "grnd_level": 999,
        "humidity": 77,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 2
      },
      "wind": {
        "speed": 3.09,
        "deg": 71,
        "gust": 5.21
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-15 03:00:00"
    },
    {
      "dt": 1663221600,
      "main": {
        "temp": 290.06,
        "feels_like": 289.84,
        "temp_min": 290.06,
        "temp_max": 290.06,
        "pressure": 1022,
        "sea_level": 1022,
        "grnd_level": 1001,
        "humidity": 78,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 8
      },
      "wind": {
        "speed": 2.9,
        "deg": 55,
        "gust": 5.22
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-15 06:00:00"
    },
    {
      "dt": 1663232400,
      "main": {
        "temp": 288.82,
        "feels_like": 288.27,
        "temp_min": 288.82,
        "temp_max": 288.82,
        "pressure": 1023,
        "sea_level": 1023,
        "grnd_level": 1002,
        "humidity": 70,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 2.9,
        "deg": 75,
        "gust": 5.66
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-15 09:00:00"
    },
    {
      "dt": 1663243200,
      "main": {
        "temp": 288.45,
        "feels_like": 287.79,
        "temp_min": 288.45,
        "temp_max": 288.45,
        "pressure": 1024,
        "sea_level": 1024,
        "grnd_level": 1003,
        "humidity": 67,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 80
      },
      "wind": {
        "speed": 2.69,
        "deg": 79,
        "gust": 5.07
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-15 12:00:00"
    },
    {
      "dt": 1663254000,
      "main": {
        "temp": 293.43,
        "feels_like": 292.87,
        "temp_min": 293.43,
        "temp_max": 293.43,
        "pressure": 1025,
        "sea_level": 1025,
        "grnd_level": 1003,
        "humidity": 52,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "clouds": {
        "all": 14
      },
      "wind": {
        "speed": 2.65,
        "deg": 104,
        "gust": 2.77
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-15 15:00:00"
    },
    {
      "dt": 1663264800,
      "main": {
        "temp": 298.49,
        "feels_like": 298.15,
        "temp_min": 298.49,
        "temp_max": 298.49,
        "pressure": 1023,
        "sea_level": 1023,
        "grnd_level": 1002,
        "humidity": 41,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "clouds": {
        "all": 12
      },
      "wind": {
        "speed": 1.27,
        "deg": 142,
        "gust": 1.72
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-15 18:00:00"
    },
    {
      "dt": 1663275600,
      "main": {
        "temp": 298.57,
        "feels_like": 298.29,
        "temp_min": 298.57,
        "temp_max": 298.57,
        "pressure": 1021,
        "sea_level": 1021,
        "grnd_level": 1000,
        "humidity": 43,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 6
      },
      "wind": {
        "speed": 2.66,
        "deg": 173,
        "gust": 2.39
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-15 21:00:00"
    },
    {
      "dt": 1663286400,
      "main": {
        "temp": 293.35,
        "feels_like": 293.07,
        "temp_min": 293.35,
        "temp_max": 293.35,
        "pressure": 1021,
        "sea_level": 1021,
        "grnd_level": 1000,
        "humidity": 63,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03n"
        }
      ],
      "clouds": {
        "all": 35
      },
      "wind": {
        "speed": 3.16,
        "deg": 145,
        "gust": 5.3
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-16 00:00:00"
    },
    {
      "dt": 1663297200,
      "main": {
        "temp": 291.55,
        "feels_like": 291.3,
        "temp_min": 291.55,
        "temp_max": 291.55,
        "pressure": 1022,
        "sea_level": 1022,
        "grnd_level": 1001,
        "humidity": 71,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 86
      },
      "wind": {
        "speed": 2.16,
        "deg": 135,
        "gust": 3.89
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-16 03:00:00"
    },
    {
      "dt": 1663308000,
      "main": {
        "temp": 291.01,
        "feels_like": 290.97,
        "temp_min": 291.01,
        "temp_max": 291.01,
        "pressure": 1022,
        "sea_level": 1022,
        "grnd_level": 1001,
        "humidity": 81,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 89
      },
      "wind": {
        "speed": 1.69,
        "deg": 121,
        "gust": 2.95
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-16 06:00:00"
    },
    {
      "dt": 1663318800,
      "main": {
        "temp": 290.82,
        "feels_like": 290.94,
        "temp_min": 290.82,
        "temp_max": 290.82,
        "pressure": 1022,
        "sea_level": 1022,
        "grnd_level": 1001,
        "humidity": 88,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 1.9,
        "deg": 107,
        "gust": 3.14
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-16 09:00:00"
    },
    {
      "dt": 1663329600,
      "main": {
        "temp": 291.11,
        "feels_like": 291.21,
        "temp_min": 291.11,
        "temp_max": 291.11,
        "pressure": 1023,
        "sea_level": 1023,
        "grnd_level": 1001,
        "humidity": 86,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 1.89,
        "deg": 128,
        "gust": 4.44
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-16 12:00:00"
    },
    {
      "dt": 1663340400,
      "main": {
        "temp": 296.8,
        "feels_like": 296.79,
        "temp_min": 296.8,
        "temp_max": 296.8,
        "pressure": 1022,
        "sea_level": 1022,
        "grnd_level": 1001,
        "humidity": 60,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 2.96,
        "deg": 153,
        "gust": 3.89
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-16 15:00:00"
    },
    {
      "dt": 1663351200,
      "main": {
        "temp": 300.33,
        "feels_like": 300.37,
        "temp_min": 300.33,
        "temp_max": 300.33,
        "pressure": 1021,
        "sea_level": 1021,
        "grnd_level": 1000,
        "humidity": 44,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 99
      },
      "wind": {
        "speed": 3.78,
        "deg": 169,
        "gust": 4.5
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-16 18:00:00"
    },
    {
      "dt": 1663362000,
      "main": {
        "temp": 301.24,
        "feels_like": 300.96,
        "temp_min": 301.24,
        "temp_max": 301.24,
        "pressure": 1019,
        "sea_level": 1019,
        "grnd_level": 998,
        "humidity": 41,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 93
      },
      "wind": {
        "speed": 3.63,
        "deg": 182,
        "gust": 5.7
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-16 21:00:00"
    },
    {
      "dt": 1663372800,
      "main": {
        "temp": 295.84,
        "feels_like": 295.84,
        "temp_min": 295.84,
        "temp_max": 295.84,
        "pressure": 1019,
        "sea_level": 1019,
        "grnd_level": 998,
        "humidity": 64,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 84
      },
      "wind": {
        "speed": 3.42,
        "deg": 153,
        "gust": 7.62
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-17 00:00:00"
    },
    {
      "dt": 1663383600,
      "main": {
        "temp": 294.04,
        "feels_like": 294.25,
        "temp_min": 294.04,
        "temp_max": 294.04,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 997,
        "humidity": 79,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 98
      },
      "wind": {
        "speed": 2.8,
        "deg": 157,
        "gust": 7.36
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-17 03:00:00"
    },
    {
      "dt": 1663394400,
      "main": {
        "temp": 293.52,
        "feels_like": 293.62,
        "temp_min": 293.52,
        "temp_max": 293.52,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 997,
        "humidity": 77,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 82
      },
      "wind": {
        "speed": 2.89,
        "deg": 200,
        "gust": 10.86
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-17 06:00:00"
    },
    {
      "dt": 1663405200,
      "main": {
        "temp": 292.91,
        "feels_like": 292.87,
        "temp_min": 292.91,
        "temp_max": 292.91,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 996,
        "humidity": 74,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 80
      },
      "wind": {
        "speed": 2.96,
        "deg": 213,
        "gust": 11.05
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2022-09-17 09:00:00"
    },
    {
      "dt": 1663416000,
      "main": {
        "temp": 292.51,
        "feels_like": 292.36,
        "temp_min": 292.51,
        "temp_max": 292.51,
        "pressure": 1018,
        "sea_level": 1018,
        "grnd_level": 997,
        "humidity": 71,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 52
      },
      "wind": {
        "speed": 2.99,
        "deg": 231,
        "gust": 11.35
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-17 12:00:00"
    },
    {
      "dt": 1663426800,
      "main": {
        "temp": 299.65,
        "feels_like": 299.65,
        "temp_min": 299.65,
        "temp_max": 299.65,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 996,
        "humidity": 44,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "clouds": {
        "all": 21
      },
      "wind": {
        "speed": 5.22,
        "deg": 219,
        "gust": 9.95
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2022-09-17 15:00:00"
    }
  ],
  "city": {
    "id": 4990729,
    "name": "Detroit",
    "coord": {
      "lat": 42.3314,
      "lon": -83.0458
    },
    "country": "US",
    "population": 713777,
    "timezone": -14400,
    "sunrise": 1662980944,
    "sunset": 1663026488
  }
}
""".trimIndent()