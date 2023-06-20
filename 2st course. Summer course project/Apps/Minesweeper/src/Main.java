import controllers.HomeController;
import models.Images;
import views.HomeView;

public class Main {
    public static void main(String[] args) throws Exception {
        /* Экземпляр класса модель Images */
        Images images = new Images();
        /* Экземпляр класса контроллера HomeController */
        HomeController homeController = new HomeController(images);
        /* Экземпляр класса представления HomeView */
        HomeView homeView = new HomeView(homeController, images);
        /* Инициализация приложения */
        homeView.main();
    }
}