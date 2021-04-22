export class Car {
    id!: string;
    brand: string;
    country: string;
    createdAt: Date;
    lastUpdated: Date;
    registration: Date;

    constructor(brand: string, country: string, createdAt: Date, lastUpdated: Date, registration: Date){
        this.brand=brand;
        this.country=country;
        this.createdAt=createdAt;
        this.lastUpdated=lastUpdated;
        this.registration=registration;
    }
}
