package com.lingona.es4j.sample.etishor.tests;

import junit.framework.Test;

//using Gallio.Framework;
//using MbUnit.Framework;
//using MbUnit.Framework.ContractVerifiers;
//using System.Reflection;
//using Sample.Messages.Events.People;

class Type {
}


//[TestFixture]
public class MessagesSerializationTests {

    // Build the test suite dynamically to be able to se which type fails the tests.
    /*//[StaticTestFactory]
    public static Iterable<Test> createTests() {
        // build suite
        TestSuite commandsSuite = new TestSuite("messages");

        for (Type message : getMessages()) {
            // build test case for each message type
            commandsSuite.getChildren().add( buildTestCase(message));
        }
        yield return commandsSuite;
    } */

    // Verify the expectations on a message type.
    // <param name="type">The message type to assert on.</param>
    private static void testType(Type type) {
        throw new UnsupportedOperationException("Not yet implemented");
        // get the fields of the type
        //FieldInfo[] fields = type.GetFields();
            
        // all fields must be public readonly
        //Assert.IsTrue(fields.All(f => f.IsPublic && f.IsInitOnly),
        //        "All fields must be marked public readonly. Not conforming:  {0}",
        //        fields.Where(f => !(f.IsPublic && f.IsInitOnly)).Select(f => f.Name).ToArray());

        // get the constructors of the type
        //ConstructorInfo[] constructors = type.GetConstructors();
            
        // the type must have exactly one constructor
        //Assert.Count(1, constructors, "The message type has {0} constructors and must have exactly 1", constructors.Count());
        //ConstructorInfo constructor = constructors.Single();

        // get the parameters of the constructor
        //ParameterInfo[] parameters = constructor.GetParameters();
            
        // the parameter count must be exactly as the field count
        //Assert.Count(fields.Count(), parameters,
        //        "The constructor parameter {0} count must be the same as the field count {1} .", parameters.Count(), fields.Count());
            
        // get the names of the fields
        //IEnumerable<string> fieldNames = fields.Select(f => f.Name.ToLowerInvariant());

        // get the names of the constructor parameters 
        //IEnumerable<string> paramNames = parameters.Select(p => p.Name.ToLowerInvariant());

        // assert they are the same
        //Assert.AreElementsEqualIgnoringOrder(fieldNames, paramNames);
    }

    // Get all the message types from the messages assembly
    private static Iterable<Type> getMessages() {
        throw new UnsupportedOperationException("Not yet implemented");
        //return typeof(Sample.Messages.IEvent).Assembly.GetTypes().Where(t => !t.IsAbstract && !t.IsInterface);
    }

    private static Test buildTestCase(Type messge) {
        throw new UnsupportedOperationException("Not yet implemented");
        //string name = string.Format("{0}.{1}", messge.Namespace.Replace(messge.Assembly.GetName().Name + ".", string.Empty), messge.Name);
        //return new TestCase(name, () => testType(messge));
    }
}

