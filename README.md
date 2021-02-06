# Тестовое задание

Технические требования:
1. Single Activity Application
2. Android 5.0+
3. Kotlin
4. Архитектура по желанию из MVP, MVVM или MVI
5. RxJava или Kotlin coroutines
6. Koin, Dagger или другой DI-фреймворк
Описание задачи :
Простое приложение с произвольным дизайном, состоящее из
последовательности следующих экранов:
1. Просмотр списка специальностей
2. Просмотр списка работников, работающих по выбранной
специальности.
Выводится имя, фамилия и возраст работника.
3. Просмотр детальной информации о работнике.
Выводится имя, фамилия, дата рождения, возраст, специальность.
Требования к работе приложения:
Данные о работниках и специальностях находятся ниже.
Приложение должно получить данные по сети.
Имя и фамилия отображаются с заглавной буквы.
Дата рождения отображается в формате число.месяц.год. Пример:
22.11.1987 г.
В случае отсутствия даты, показывать прочерк --
В случае ошибки, отображать пользователю Toast с сообщением
“Произошла ошибка”
Дополнительно:
Кешировать полученные данные в БД и использовать их при работе

## JSON

{
	"response" : [
		{
			"f_name" 	: "иВан",
			"l_name" 	: "ИваноВ",
			"birthday"	: "1987-03-23",
			"avatr_url"	: "https://2.cdn.echo.msk.ru/files/avatar2/2561900.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			}]
		},
		{
			"f_name" 	: "Петр",
			"l_name" 	: "петроВ",
			"birthday"	: null,
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/1253126.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			}]
		},
		{
			"f_name" 	: "Вася",
			"l_name" 	: "Пупкин",
			"birthday"	: "1985-11-29",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/1450682.jpg",
			"specialty" : [{
				"specialty_id" : 101,
				"name"	: "Менеджер"
			},
			{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "ЕКАТЕРИНА",
			"l_name" 	: "пертрова",
			"birthday"	: "1990-01-07",
			"avatr_url" : "",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Николай",
			"l_name" 	: "Сидоров",
			"birthday"	: "",
			"avatr_url" : null,
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Виктор",
			"l_name" 	: "Федотов",
			"birthday"	: "23-07-2000",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/2441412.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Артур",
			"l_name" 	: "ВАрламов",
			"birthday"	: "23-07-2000",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/808879.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Артур",
			"l_name" 	: "ВАрламов",
			"birthday"	: "23-07-1982",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/2933492.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Руслан",
			"l_name" 	: "Русанов",
			"birthday"	: "17-10-1984",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/844319.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		},
		{
			"f_name" 	: "Владимир",
			"l_name" 	: "Миронов",
			"birthday"	: "03-08-1972",
			"avatr_url" : "https://2.cdn.echo.msk.ru/files/avatar2/3073407.jpg",
			"specialty" : [{
				"specialty_id" : 102,
				"name"	: "Разработчик"
			}]
		}
	]
}
