import { Brand } from "./brand";
import { Country } from "./country";

export class Car {
    id!: string;
    brand: Brand;
    country: Country;
    createdAt: Date;
    lastUpdated: Date;
    registration: Date;

    constructor(brand: Brand, country: Country, createdAt: Date, lastUpdated: Date, registration: Date){
        this.brand=brand;
        this.country=country;
        this.createdAt=createdAt;
        this.lastUpdated=lastUpdated;
        this.registration=registration;
    }
}
