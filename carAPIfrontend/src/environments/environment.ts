// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  carsUrl: "http://desktop-i5ipudi:8080/carAPI-0.0.1-SNAPSHOT/cars",
  brandsUrl: "http://desktop-i5ipudi:8080/carAPI-0.0.1-SNAPSHOT/brands",
  countriesUrl: "http://desktop-i5ipudi:8080/carAPI-0.0.1-SNAPSHOT/countries",
  loginUrl: "http://desktop-i5ipudi:8080/carAPI-0.0.1-SNAPSHOT/login"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
