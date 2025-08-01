<?php

namespace OpenAPI\Client;

use OpenAPI\Client\Api\PetApi;
use OpenAPI\Client\Model\ApiResponse;
use OpenAPI\Client\Model\Pet;
use PHPUnit\Framework\TestCase;
use PHPUnit\Framework\Assert;

class PetApiTest extends TestCase
{

    /** @var  PetApi */
    private $api;

    // add a new pet (id 10005) to ensure the pet object is available for all the tests
    public static function setUpBeforeClass(): void
    {
        // increase memory limit to avoid fatal error due to findPetByStatus
        // returning a lot of data
        ini_set('memory_limit', '256M');

        // enable debugging
        //Configuration::$debug = true;

        // new pet
        $newPetId = 10005;
        $newPet = new Model\Pet;
        $newPet->setId($newPetId);
        $newPet->setName("PHP Unit Test");
        $newPet->setPhotoUrls(["http://test_php_unit_test.com"]);
        // new tag
        $tag = new Model\Tag;
        $tag->setId($newPetId); // use the same id as pet
        $tag->setName("test php tag");
        // new category
        $category = new Model\Category;
        $category->setId($newPetId); // use the same id as pet
        $category->setName("test php category");

        $newPet->setTags(array($tag));
        $newPet->setCategory($category);
    }

    public function setUp(): void
    {
        $config = (new Configuration())->setHost('http://localhost/v2');
        $this->api = new Api\PetApi(null, $config);
    }

    public function testGetPetById()
    {
        $petId = 10005;

        $pet = $this->api->getPetById($petId);
        $this->assertSame($petId, $pet->getId());
        $this->assertSame('PHP Unit Test', $pet->getName());
        $this->assertSame('http://test_php_unit_test.com', $pet->getPhotoUrls()[0]);
        $this->assertSame($petId, $pet->getCategory()->getId());
        $this->assertSame('test php category', $pet->getCategory()->getName());
        $this->assertSame($petId, $pet->getTags()[0]->getId());
        $this->assertSame('test php tag', $pet->getTags()[0]->getName());
    }

    /**
     * comment out as we've removed invalid endpoints from the spec, we'll introduce something
     * similar in the future when we've time to update the petstore server
     *
     * // test getPetById with a Pet object (id 10005)
     * public function testGetPetByIdInObject()
     * {
     * // initialize the API client without host
     * $pet_id = 10005;  // ID of pet that needs to be fetched
     * $pet_api = new Api\PetApi();
     * $pet_api->getApiClient()->getConfig()->setApiKey('api_key', '111222333444555');
     * // return Pet (inline model)
     * $response = $pet_api->getPetByIdInObject($pet_id);
     * $this->assertInstanceOf('OpenAPI\Client\Model\InlineResponse200', $response);
     * $this->assertSame($response->getId(), $pet_id);
     * $this->assertSame($response->getName(), 'PHP Unit Test');
     * $this->assertSame($response->getPhotoUrls()[0], 'http://test_php_unit_test.com');
     *
     * // category is type "object"
     * $this->assertInternalType('array', $response->getCategory());
     * $this->assertSame($response->getCategory()['id'], $pet_id);
     * $this->assertSame($response->getCategory()['name'], 'test php category');
     *
     * $this->assertSame($response->getTags()[0]->getId(), $pet_id);
     * $this->assertSame($response->getTags()[0]->getName(), 'test php tag');
     * }
     */

    // test getPetByIdWithHttpInfo with a Pet object (id 10005)
    public function testGetPetByIdWithHttpInfo()
    {
        // initialize the API client without host
        $petId = 10005;  // ID of pet that needs to be fetched

        /** @var $pet Pet */
        list($pet, $status_code, $response_headers) = $this->api->getPetByIdWithHttpInfo($petId);
        $this->assertSame($petId, $pet->getId());
        $this->assertSame('PHP Unit Test', $pet->getName());
        $this->assertSame($petId, $pet->getCategory()->getId());
        $this->assertSame('test php category', $pet->getCategory()->getName());
        $this->assertSame($petId, $pet->getTags()[0]->getId());
        $this->assertSame('test php tag', $pet->getTags()[0]->getName());
        $this->assertSame(200, $status_code);
        $this->assertSame(['application/json'], $response_headers['Content-Type']);
    }

    public function testFindPetByStatus()
    {
        $response = $this->api->findPetsByStatus('available');
        $this->assertGreaterThan(0, count($response)); // at least one object returned

        $this->assertInstanceOf(Pet::class, $response[0]); // verify the object is Pet
        foreach ($response as $pet) {
            $this->assertSame('available', $pet->getStatus());
        }

        $response = $this->api->findPetsByStatus('unknown_and_incorrect_status');
        $this->assertCount(0, $response);
    }

    public function testUpdatePet()
    {
        $petId = 10001;
        $updatedPet = new Model\Pet;
        $updatedPet->setId($petId);
        $updatedPet->setName('updatePet');
        $updatedPet->setStatus('pending');
        $result = $this->api->updatePet($updatedPet);
        $this->assertNull($result);

        // verify updated Pet
        $result = $this->api->getPetById($petId);
        $this->assertSame($petId, $result->getId());
        $this->assertSame('pending', $result->getStatus());
        $this->assertSame('updatePet', $result->getName());
    }

    // test updatePetWithFormWithHttpInfo and verify by the "name" of the response
    public function testUpdatePetWithFormWithHttpInfo()
    {
        $petId = 10001;  // ID of pet that needs to be fetched

        // update Pet (form)
        list($update_response, $status_code, $http_headers) = $this->api->updatePetWithFormWithHttpInfo(
            $petId,
            'update pet with form with http info'
        );
        // return nothing (void)
        $this->assertNull($update_response);
        $this->assertSame(200, $status_code);
        $this->assertSame(['application/json'], $http_headers['Content-Type']);
        $response = $this->api->getPetById($petId);
        $this->assertSame($petId, $response->getId());
        $this->assertSame('update pet with form with http info', $response->getName());
    }

    // test updatePetWithForm and verify by the "name" and "status" of the response
    public function testUpdatePetWithForm()
    {
        $pet_id = 10001;  // ID of pet that needs to be fetched
        $result = $this->api->updatePetWithForm($pet_id, 'update pet with form', 'sold');
        // return nothing (void)
        $this->assertNull($result);

        $response = $this->api->getPetById($pet_id);
        $this->assertSame($pet_id, $response->getId());
        $this->assertSame('update pet with form', $response->getName());
        $this->assertSame('sold', $response->getStatus());
    }

    // test addPet and verify by the "id" and "name" of the response
    public function testAddPet()
    {
        $new_pet_id = 10005;
        $newPet = new Model\Pet;
        $newPet->setId($new_pet_id);
        $newPet->setName("PHP Unit Test 2");

        // add a new pet (model)
        $add_response = $this->api->addPet($newPet);
        // return nothing (void)
        $this->assertNull($add_response);

        // verify added Pet
        $response = $this->api->getPetById($new_pet_id);
        $this->assertSame($new_pet_id, $response->getId());
        $this->assertSame('PHP Unit Test 2', $response->getName());
    }

    /*
     * comment out as we've removed invalid endpoints from the spec, we'll introduce something
     * similar in the future when we've time to update the petstore server
     *
    // test addPetUsingByteArray and verify by the "id" and "name" of the response
    public function testAddPetUsingByteArray()
    {
        // initialize the API client
        $config = (new Configuration())->setHost('http://petstore.swagger.io/v2');
        $api_client = new ApiClient($config);

        $new_pet_id = 10005;
        $new_pet = new Model\Pet;
        $new_pet->setId($new_pet_id);
        $new_pet->setName("PHP Unit Test 3");
        // new tag
        $tag= new Model\Tag;
        $tag->setId($new_pet_id); // use the same id as pet
        $tag->setName("test php tag");
        // new category
        $category = new Model\Category;
        $category->setId($new_pet_id); // use the same id as pet
        $category->setName("test php category");
  
        $new_pet->setTags(array($tag));
        $new_pet->setCategory($category);

        $pet_api = new Api\PetApi($api_client);
        // add a new pet (model)
        $object_serializer = new ObjectSerializer();
        $pet_json_string = json_encode($object_serializer->sanitizeForSerialization($new_pet));
        $add_response = $pet_api->addPetUsingByteArray($pet_json_string);
        // return nothing (void)
        $this->assertSame($add_response, NULL);
        // verify added Pet
        $response = $pet_api->getPetById($new_pet_id);
        $this->assertSame($response->getId(), $new_pet_id);
        $this->assertSame($response->getName(), 'PHP Unit Test 3');
    }
     */

    // test upload file
    public function testUploadFile()
    {
        // upload file
        $pet_id = 10001;
        $response = $this->api->uploadFile($pet_id, 'test meta', __DIR__ . '/../composer.json');
        // return ApiResponse
        $this->assertInstanceOf(ApiResponse::class, $response);
    }

    /*
     * comment out as we've removed invalid endpoints from the spec, we'll introduce something
     * similar in the future when we've time to update the petstore server
     *
    // test byte array response
    public function testGetPetByIdWithByteArray()
    {
        // initialize the API client
        $config = new Configuration();
        $config->setHost('http://petstore.swagger.io/v2');
        $api_client = new APIClient($config);
        $pet_api = new Api\PetApi($api_client);
        // test getPetByIdWithByteArray 
        $pet_id = 10005;
        $bytes = $pet_api->petPetIdtestingByteArraytrueGet($pet_id);
        $json = json_decode($bytes, true);

        $this->assertInternalType("string", $bytes);

        $this->assertSame($json['id'], $pet_id);
        // not testing name as it's tested by addPetUsingByteArray
        //$this->assertSame($json['name'], 'PHP Unit Test');
        $this->assertSame($json['category']['id'], $pet_id);
        $this->assertSame($json['category']['name'], 'test php category');
        $this->assertSame($json['tags'][0]['id'], $pet_id);
        $this->assertSame($json['tags'][0]['name'], 'test php tag');
    }
     */

    // test empty object serialization
    public function testEmptyPetSerialization()
    {
        $new_pet = new Model\Pet;
        // the empty object should be serialised to {}
        $this->assertSame("{}", "$new_pet");
    }

    // test inheritance in the model
    public function testInheritance()
    {
        $new_dog = new Model\Dog;
        // the object should be an instance of the derived class
        $this->assertInstanceOf('OpenAPI\Client\Model\Dog', $new_dog);
        // the object should also be an instance of the parent class
        $this->assertInstanceOf('OpenAPI\Client\Model\Animal', $new_dog);
    }

    // test inheritance constructor is working with data
    // initialization
    public function testInheritanceConstructorDataInitialization()
    {
        // initialize the object with data in the constructor
        $data = array(
            'class_name' => 'Dog',
            'breed' => 'Great Dane'
        );
        $new_dog = new Model\Dog($data);

        // the property on the derived class should be set
        $this->assertSame('Great Dane', $new_dog->getBreed());
        // the property on the parent class should be set
        $this->assertSame('Dog', $new_dog->getClassName());
    }

    // test if discriminator is initialized automatically
    public function testDiscriminatorInitialization()
    {
        $new_dog = new Model\Dog();
        $this->assertSame('Dog', $new_dog->getClassName());
    }

    // test if ArrayAccess interface works
    public function testArrayStuff()
    {
        // create an array of Animal
        $farm = array();

        // add some animals to the farm to make sure the ArrayAccess
        // interface works
        $farm[] = new Model\Dog();
        $farm[] = new Model\Cat();
        $farm[] = new Model\Animal();

        // assert we can look up the animals in the farm by array
        // indices (let's try a random order)
        $this->assertInstanceOf('OpenAPI\Client\Model\Cat', $farm[1]);
        $this->assertInstanceOf('OpenAPI\Client\Model\Dog', $farm[0]);
        $this->assertInstanceOf('OpenAPI\Client\Model\Animal', $farm[2]);

        // let's try to `foreach` the animals in the farm and let's
        // try to use the objects we loop through
        foreach ($farm as $animal) {
            $this->assertContains($animal->getClassName(), array('Dog', 'Cat', 'Animal'));
            $this->assertInstanceOf('OpenAPI\Client\Model\Animal', $animal);
        }
    }

    // test if default values works
    public function testDefaultValues()
    {
        // add some animals to the farm to make sure the ArrayAccess
        // interface works
        $dog = new Model\Dog();
        $animal = new Model\Animal();

        // assert we can look up the animals in the farm by array
        // indices (let's try a random order)
        $this->assertSame('red', $dog->getColor());
        $this->assertSame('red', $animal->getColor());
    }

    /**
     * test invalid argument
     */
    public function testInvalidArgument()
    {
        // the argument is required, and we must specify one or some from 'available', 'pending', 'sold'
        $this->expectException(\InvalidArgumentException::class);
        $this->expectExceptionMessage('Missing the required parameter $status when calling findPetsByStatus');
        $this->api->findPetsByStatus([]);
    }

    public function testObjectInFormData()
    {
        $category = (new Model\Category())
            ->setId(12345)
            ->setName("Category_Name");

        $tags_1 = (new Model\Tag())
            ->setId(12345)
            ->setName("tag_1");

        $tags_2 = (new Model\Tag())
            ->setId(98765)
            ->setName("tag_2");

        /** @var Model\Tag[] $tags */
        $tags = [
            $tags_1,
            $tags_2,
        ];

        $pet_id = 56;
        $name = "My pet name";
        $photo_urls = [
            "https://example.com/picture_1.jpg",
            "https://example.com/picture_2.jpg",
        ];
        $id = 12345;
        $status = Model\Pet::STATUS_AVAILABLE;
        $file = new \SplFileObject(__DIR__ . '/../.openapi-generator/VERSION');
        $multiple_files = [
            $file,
            $file,
        ];

        $request = (new Api\PetApi())->uploadImageFullFormDataRequest(
            $pet_id,
            $name,
            $photo_urls,
            $id,
            $category,
            $tags,
            $status,
            $file,
            $multiple_files,
        );

        $contents = $request->getBody()->getContents();

        $this->assertBodyContents('name', $name, $contents);
        $this->assertBodyContents('photo_urls[0]', $photo_urls[0], $contents);
        $this->assertBodyContents('photo_urls[1]', $photo_urls[1], $contents);
        $this->assertBodyContents('category[id]', $category->getId(), $contents);
        $this->assertBodyContents('category[name]', $category->getName(), $contents);
        $this->assertBodyContents('tags[0][id]', $tags[0]->getId(), $contents);
        $this->assertBodyContents('tags[0][name]', $tags[0]->getName(), $contents);
        $this->assertBodyContents('tags[1][id]', $tags[1]->getId(), $contents);
        $this->assertBodyContents('tags[1][name]', $tags[1]->getName(), $contents);
        $this->assertBodyContents('status', $status, $contents);
    }

    private function assertBodyContents(
        string $name,
        mixed $value,
        string $contents,
    ) {
        $length = strlen((string) ($value));
        $contents = implode("\n", array_map('trim', explode("\n", $contents)));

        $expected = <<<END
            Content-Disposition: form-data; name="{$name}"
            Content-Length: {$length}
            
            {$value}
            END;

        $this->assertStringContainsString($expected, $contents);
    }

//    Disabled as currently we don't have any endpoint that would return file
//    For testing I just replaced url and return type in Api method.
//    public function testDownloadingLargeFile()
//    {
//        $petId = 10005;
//        $config = new Configuration();
//        $config->setHost('https://getcomposer.org');
//        $api = new PetApi(new Client(), $config);
//        $result = $api->getPetById($petId);
//        $this->assertInstanceOf(\SplFileObject::class, $result);
//        var_dump([
//            'peak mem (MiB)' => memory_get_peak_usage(true)/1024/1024,
//            'file size (MiB)' => $result->getSize()/1024/1024,
//            'path' => sys_get_temp_dir() . '/' . $result->getFilename()
//        ]);
//    }
}
